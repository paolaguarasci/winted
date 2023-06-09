package it.pingflood.wintedbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@Profile(value = {"dev", "prod"})
public class AuditConfiguration {
  
  @Bean
  public AuditorAware<String> auditorAware() {
    return new EntityAuditorAware();
  }
  
}
