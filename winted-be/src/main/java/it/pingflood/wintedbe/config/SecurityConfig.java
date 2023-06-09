package it.pingflood.wintedbe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile(value = {"dev", "prod"})
public class SecurityConfig {
  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuerUri;
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    System.out.println("DEV===================================================");
    http.cors()
      .and().authorizeHttpRequests()
      .requestMatchers(HttpMethod.GET, "/api/products/**")
      .hasAuthority("SCOPE_product:read")
      .requestMatchers(HttpMethod.GET, "/api/orders/**")
      .hasAuthority("SCOPE_order:read")
      
      
      .requestMatchers(HttpMethod.GET, "/v3/api-docs", "swagger-ui/index.html")
      .hasAuthority("SCOPE_documentation")
      
      .requestMatchers(HttpMethod.GET, "/api/users/info")
      .hasAuthority("SCOPE_profile")
      
      // .anyRequest().authenticated()
      .and()
      .oauth2ResourceServer(oauth2 -> oauth2
        .jwt(jwt -> jwt
          .decoder(jwtDecoder())
        )
      );
    return http.build();
    
  }
  
  OAuth2TokenValidator<Jwt> audienceValidator() {
    return new AudienceValidator();
  }
  
  @Bean(name = "JWTDEC")
  JwtDecoder jwtDecoder() {
    System.out.println("issuerUri " + issuerUri);
    
    NimbusJwtDecoder jwtDecoder = JwtDecoders.fromIssuerLocation(issuerUri);
    
    OAuth2TokenValidator<Jwt> audienceValidator = audienceValidator();
    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuerUri);
    OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);
    
    jwtDecoder.setJwtValidator(withAudience);
    
    return jwtDecoder;
  }
  
  static class AudienceValidator implements OAuth2TokenValidator<Jwt> {
    OAuth2Error error = new OAuth2Error("custom_code", "Custom error message", null);
    
    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {
      if (jwt.getAudience().contains("web")) {
        return OAuth2TokenValidatorResult.success();
      } else {
        return OAuth2TokenValidatorResult.failure(error);
      }
    }
  }
  
  @Configuration
  @EnableWebMvc
  public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**");
    }
  }
}
