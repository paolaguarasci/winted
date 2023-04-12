package it.pingflood.wintedbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Profile("test")
@Configuration
public class SecurityConfigTest {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    System.out.println("TEST===================================================");
    http
      .headers().frameOptions().sameOrigin()
      .and()
      .csrf().disable();
    return http.build();
  }
}
