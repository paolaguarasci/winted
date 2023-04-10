package it.pingflood.wintedbe.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class EntityAuditorAware implements AuditorAware<String> {
  @Override
  public Optional<String> getCurrentAuditor() {
    // TODO Get current logged customer
    return Optional.of("Paola");
  }
}
