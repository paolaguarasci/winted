package it.pingflood.wintedbe.config;

import it.pingflood.wintedbe.data.service.LogService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestLoggingFilterConfig {
  private final LogService logService;
  
  public RequestLoggingFilterConfig(LogService logService) {
    this.logService = logService;
  }
  
//  @Bean
//  public CommonsRequestLoggingFilter logFilter() {
//    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
//    loggingFilter.setIncludeClientInfo(true);
//    loggingFilter.setIncludeHeaders(true);
//    loggingFilter.setIncludePayload(false);
//    loggingFilter.setIncludeQueryString(true);
//    //    logService.print(Log.builder().method(Log.REQUEST_METHOD.GET).uri("sss").status(Log.REQUEST_STATUS.OK).at(LocalDateTime.now()).customer().build());
//    //    logService.print(Log.builder().method(Log.REQUEST_METHOD.GET).uri("sss").status(Log.REQUEST_STATUS.OK).build());
//    logService.save(new Log());
//    return loggingFilter;
//  }
  
//  @Bean
//  CommonsRequestLoggingFilter loggingFilter(){
//    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
//    loggingFilter.setIncludeClientInfo(true);
//    loggingFilter.setIncludeQueryString(true);
//    // loggingFilter.setIncludeHeaders(true);
//    // loggingFilter.setIncludePayload(true);
//    // loggingFilter.setMaxPayloadLength(10000);
//    return loggingFilter;
//  }
  
}
