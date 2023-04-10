package it.pingflood.wintedbe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler({CallNotPermittedException.class})
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public void handleCallNotPermittedException() {
  }
  
  
  @ExceptionHandler({ RequestNotPermitted.class })
  @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
  public void handleRequestNotPermitted() {
    System.out.println("Error");
  }
}