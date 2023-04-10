package it.pingflood.wintedbe.data.service.impl;

import it.pingflood.wintedbe.data.entity.Order;
import it.pingflood.wintedbe.data.repo.OrderRepository;
import it.pingflood.wintedbe.data.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;
  
  
  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }
  
  
  @Override
  public Optional<Order> findById(UUID id) {
    return orderRepository.findById(id);
  }
  
  @Override
  public Order save(Order product) {
    return orderRepository.save(product);
  }
  
  @Override
  public List<Order> findAll() {
    return orderRepository.findAll();
  }
}
