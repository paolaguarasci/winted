package it.pingflood.wintedbe.data.service;

import it.pingflood.wintedbe.data.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
  Optional<Order> findById(UUID id);
  
  Order save(Order product);
  
  List<Order> findAll();
}
