package it.pingflood.wintedbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.cors()
//      .and().authorizeHttpRequests()
//      .requestMatchers(HttpMethod.GET, "/api/product/**")
//      .hasAuthority("SCOPE_read")
//      .requestMatchers(HttpMethod.POST, "/api/product")
//      .hasAuthority("SCOPE_write")
//      .anyRequest()
//      .authenticated()
//      .and()
//      .oauth2ResourceServer((oauth2) -> {
//        oauth2.jwt().decoder(jwtDecoder());
//        oauth2.jwt();
//      });
    return http.build();
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
  
  OAuth2TokenValidator<Jwt> audienceValidator() {
    return new AudienceValidator();
  }
  
  @Bean
  JwtDecoder jwtDecoder() {
    var issuerUri = "http://localhost:8080/realms/winted";
    NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)
      JwtDecoders.fromIssuerLocation(issuerUri);
    
    OAuth2TokenValidator<Jwt> audienceValidator = audienceValidator();
    OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer(issuerUri);
    OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<>(withIssuer, audienceValidator);
    
    jwtDecoder.setJwtValidator(withAudience);
    
    return jwtDecoder;
  }
  
  
}
