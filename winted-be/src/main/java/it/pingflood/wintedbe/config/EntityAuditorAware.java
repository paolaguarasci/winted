package it.pingflood.wintedbe.config;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;
@Profile(value = {"dev", "prod"})
public class EntityAuditorAware implements AuditorAware<String> {
  
  @Override
  public Optional<String> getCurrentAuditor() {
    var authentication = SecurityContextHolder.getContext().getAuthentication();
    var jwt = (Jwt) authentication.getPrincipal();
    var username = (String) jwt.getClaims().get("preferred_username");
    return Optional.of(username);
  }
}
