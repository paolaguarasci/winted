package it.pingflood.wintedbe.rest;


import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import it.pingflood.wintedbe.data.dto.OrderDTO;
import it.pingflood.wintedbe.data.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class OrderController {
  private final OrderService orderService;
  private final ModelMapper modelMapper;
  
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
    modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
      .setFieldMatchingEnabled(true)
      .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
  }
  
  @GetMapping(value = "/orders")
  @RateLimiter(name = "retryAndRateLimitExample")
  @PreAuthorize("hasAuthority('SCOPE_order:read')")
  public ResponseEntity<List<OrderDTO>> findAll() {
    return ResponseEntity.ok(orderService.findAll().stream().map(order -> modelMapper.map(order, OrderDTO.class)).toList());
  }
  
  @GetMapping(value = "/orders/{id}")
  @RateLimiter(name = "retryAndRateLimitExample")
  @PreAuthorize("hasAuthority('SCOPE_order:read')")
  public ResponseEntity<OrderDTO> findOne(@PathVariable UUID id) {
    return ResponseEntity.ok(modelMapper.map(orderService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), OrderDTO.class));
  }
}
