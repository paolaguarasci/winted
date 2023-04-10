package it.pingflood.wintedbe.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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

import java.util.Objects;

@Configuration
public class SecurityConfig {
  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String issuerUri;
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors()
      .and().authorizeHttpRequests()
      .requestMatchers(HttpMethod.GET, "/api/product/**")
      .hasAuthority("SCOPE_read")
      .requestMatchers(HttpMethod.POST, "/api/product")
      .hasAuthority("SCOPE_write")
      .anyRequest()
      .authenticated()
      .and()
      .oauth2ResourceServer((oauth2) -> {
        oauth2.jwt().decoder(jwtDecoder());
        oauth2.jwt();
      });
    return http.build();
  }
  
  @Configuration
  @EnableWebMvc
  public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**");
    }
  }
  
  static class AudienceValidator implements OAuth2TokenValidator<Jwt> {
    OAuth2Error error = new OAuth2Error("custom_code", "Custom error message", null);
    
    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {
      System.out.println("TOKEN - " + jwt.toString());
      if (jwt.getAudience().contains("web")) {
        return OAuth2TokenValidatorResult.success();
      } else {
        return OAuth2TokenValidatorResult.failure(error);
      }
    }
  }
  
  OAuth2TokenValidator<Jwt> audienceValidator() {
    return new AudienceValidator();
  }
  
  @Bean
  JwtDecoder jwtDecoder() {
    System.out.println("issuerUri " + issuerUri);
    
    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromIssuerLocation(issuerUri);

    OAuth2TokenValidator<Jwt> audienceValidator = audienceValidator();
    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuerUri);
    OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);
    
    jwtDecoder.setJwtValidator(withAudience);
    
    return jwtDecoder;
  }
  
  @Configuration
  public static class SSLConfig {
    private final Environment env;
    
    public SSLConfig(Environment env) {
      this.env = env;
    }
    
    @PostConstruct
    private void configureSSL() {
      System.out.println("=================================== SSL CONFIG ============================================================");
      System.setProperty("https.protocols", "TLSv1.3");
      System.setProperty("javax.net.ssl.trustStore", Objects.requireNonNull(env.getProperty("server.ssl.trust-store")));
      System.setProperty("javax.net.ssl.trustStorePassword", Objects.requireNonNull(env.getProperty("server.ssl.trust-store-password")));
    }
  }
  
}