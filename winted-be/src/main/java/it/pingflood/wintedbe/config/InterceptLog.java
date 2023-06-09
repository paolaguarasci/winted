package it.pingflood.wintedbe.config;

import it.pingflood.wintedbe.data.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Profile(value = {"dev", "prod"})
public class InterceptLog implements HandlerInterceptor {
  
  private final LogService logService;
  
  public InterceptLog(LogService logService) {
    this.logService = logService;
  }
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    logService.displayReq(request, null);
    return true;
  }
  
  
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    logService.displayResp(request, response, null);
  }
  
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
    logService.save(request, response, handler.toString()); // salva il metodo che ha gestito la chiamata
  }
  
}
