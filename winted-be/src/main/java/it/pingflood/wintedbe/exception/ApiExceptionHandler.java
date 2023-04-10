package it.pingflood.wintedbe.exception;

import it.pingflood.wintedbe.data.service.LogService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
  
  private final LogService logService;
  
  public ApiExceptionHandler(LogService logService) {
    super();
    this.logService = logService;
  }
  
 
  @ExceptionHandler({ DataIntegrityViolationException.class })
  public ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex, final WebRequest request) {
    Map<String, String> bodyResp = new HashMap<String, String>();
    return handleExceptionInternal(ex, bodyResp.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }
  

  protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
    final String bodyOfResponse = "This should be application specific";
    // ex.getCause() instanceof JsonMappingException, JsonParseException // for additional information later on
    return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
  }
  

  protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
    final String bodyOfResponse = "This should be application specific";
    return handleExceptionInternal(ex, bodyOfResponse, headers, HttpStatus.BAD_REQUEST, request);
  }
  

  @ExceptionHandler({ AccessDeniedException.class })
  public ResponseEntity<Object> handleAccessDeniedException(final Exception ex, final WebRequest request) {
    System.out.println("request" + request.getUserPrincipal());
    return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
  }
  @ExceptionHandler({ InvalidDataAccessApiUsageException.class, DataAccessException.class })
  protected ResponseEntity<Object> handleConflict(final RuntimeException ex, final WebRequest request) {
    final String bodyOfResponse = "This should be application specific";
    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    
  }

  @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleInternal(final RuntimeException ex, final WebRequest request) {
    return handleExceptionInternal(ex, makeBodyOfResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "INTERNAL SERVER ERROR"), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
  }
  
  @ExceptionHandler(value = {Exception.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String internalServerError(Exception ex) {
    return "Internal error";
  }
  
  private Map<String, String> makeBodyOfResponse(HttpStatus status, String msg, String error) {
    Map<String, String> bodyResp = new HashMap<String, String>();
    bodyResp.put("timestamp", String.valueOf(LocalDateTime.now()));
    bodyResp.put("status", String.valueOf(status.series()));
    bodyResp.put("error", status.getReasonPhrase());
    bodyResp.put("message", msg);
    return bodyResp;
  }
  
}
