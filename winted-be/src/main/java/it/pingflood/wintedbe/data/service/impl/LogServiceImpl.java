package it.pingflood.wintedbe.data.service.impl;

import it.pingflood.wintedbe.data.entity.Log;
import it.pingflood.wintedbe.data.repo.LogRepository;
import it.pingflood.wintedbe.data.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class LogServiceImpl implements LogService {
  
  private final LogRepository logRepository;
  
  public LogServiceImpl(LogRepository logRepository) {
    this.logRepository = logRepository;
  }
  
  @Override
  public void print(Log log) {
    System.out.println("LOG SERVICE - " + log);
  }
  
  @Override
  public Log save(Log log) {
    return logRepository.save(log);
  }
  Logger logger = LoggerFactory.getLogger("LoggingServiceImpl");
  
  @Override
  public void displayReq(HttpServletRequest request, Object body) {
    StringBuilder reqMessage = new StringBuilder();
    
    System.out.println(" - PRINCIPAL - " + request.getUserPrincipal());
    
    Map<String,String> parameters = getParameters(request);
    
    reqMessage.append("REQUEST ");
    reqMessage.append("method = [").append(request.getMethod()).append("]");
    reqMessage.append(" path = [").append(request.getRequestURI()).append("] ");
    
    if(!parameters.isEmpty()) {
      reqMessage.append(" parameters = [").append(parameters).append("] ");
    }
    
    if(!Objects.isNull(body)) {
      reqMessage.append(" body = [").append(body).append("]");
    }
    
    logger.info("log Request: {}", reqMessage);
  }
  
  @Override
  public void displayResp(HttpServletRequest request, HttpServletResponse response, Object body) {
    StringBuilder respMessage = new StringBuilder();
    Map<String,String> headers = getHeaders(response);
    respMessage.append("RESPONSE ");
    respMessage.append(" method = [").append(request.getMethod()).append("]");
    if(!headers.isEmpty()) {
      respMessage.append(" ResponseHeaders = [").append(headers).append("]");
    }
    respMessage.append(" responseBody = [").append(body).append("]");
    
    logger.info("logResponse: {}",respMessage);
  }
  @Override
  public void save(HttpServletRequest request, HttpServletResponse response, Object body) {
    String message = "";
    if (body != null) {
      message = (String) body;
      System.out.println("Body " + body);
    }
    Log log = Log.builder().customer_id(request.getUserPrincipal().getName()).status(response.getStatus()).message(message).uri(request.getRequestURI()).method(Log.REQUEST_METHOD.valueOf(request.getMethod())).at(LocalDateTime.now()).build();
    logRepository.save(log);
  }
  
  private Map<String,String> getHeaders(HttpServletResponse response) {
    Map<String,String> headers = new HashMap<>();
    Collection<String> headerMap = response.getHeaderNames();
    for(String str : headerMap) {
      headers.put(str,response.getHeader(str));
    }
    return headers;
  }
  
  private Map<String,String> getParameters(HttpServletRequest request) {
    Map<String,String> parameters = new HashMap<>();
    Enumeration<String> params = request.getParameterNames();
    while(params.hasMoreElements()) {
      String paramName = params.nextElement();
      String paramValue = request.getParameter(paramName);
      parameters.put(paramName,paramValue);
    }
    return parameters;
  }
  
}
