package it.pingflood.wintedbe.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Profile(value = {"dev", "prod"})
public class CustomWebConfigurer implements WebMvcConfigurer {
  
  private final InterceptLog logInterceptor;
  
  public CustomWebConfigurer(InterceptLog logInterceptor) {
    this.logInterceptor = logInterceptor;
  }
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(logInterceptor);
  }
}
