package it.pingflood.wintedbe.rest;


import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import it.pingflood.wintedbe.data.dto.CustomerDTO;
import it.pingflood.wintedbe.data.service.CustomerService;
import it.pingflood.wintedbe.data.service.LogService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class CustomerController {
  private final CustomerService customerService;
  
  private final ModelMapper modelMapper;
  private LogService logService;
  
  public CustomerController(CustomerService customerService, LogService logService) {
    this.customerService = customerService;
    this.logService = logService;
    this.modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
      .setFieldMatchingEnabled(true)
      .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
  }
  
  @GetMapping(value = "/users")
  @RateLimiter(name = "users-findAll")
  public ResponseEntity<List<CustomerDTO>> findAll() {
    return ResponseEntity.ok(customerService.findAll()
      .stream()
      .map(user -> modelMapper.map(user, CustomerDTO.class))
      .toList());
  }
  
  @GetMapping(value = "/users/{id}")
  @RateLimiter(name = "users-findOne")
  public ResponseEntity<CustomerDTO> findOne(@PathVariable UUID id) {
    return ResponseEntity.ok(modelMapper.map(customerService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), CustomerDTO.class));
  }
  
  @GetMapping(value = "/users/info")
  @RateLimiter(name = "customer-getUserInfo")
  public ResponseEntity<CustomerDTO> getUserInfo(Model model, @AuthenticationPrincipal OAuth2User oauth2User) {
    return ResponseEntity.ok(modelMapper.map(customerService.getUserInfo(), CustomerDTO.class));
  }
}
