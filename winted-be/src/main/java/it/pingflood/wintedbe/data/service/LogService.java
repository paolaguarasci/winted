package it.pingflood.wintedbe.data.service;

import it.pingflood.wintedbe.data.entity.Log;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface LogService {
  void print(Log log);
  
  Log save(Log log);
  
  
  void displayReq(HttpServletRequest request, Object body);
  
  void displayResp(HttpServletRequest request, HttpServletResponse response, Object body);
  
 
  void save(HttpServletRequest request, HttpServletResponse response, Object body);
}
