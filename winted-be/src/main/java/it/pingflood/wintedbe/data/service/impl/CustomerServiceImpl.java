package it.pingflood.wintedbe.data.service.impl;

import it.pingflood.wintedbe.data.entity.Customer;
import it.pingflood.wintedbe.data.repo.CustomerRepository;
import it.pingflood.wintedbe.data.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
  
  private final CustomerRepository customerRepository;
  
 
  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }
  
  @Override
  public Optional<Customer> findById(UUID id) {
    return customerRepository.findById(id);
  }
  
  @Override
  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }
  
  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }
  
  @Override
  public Optional<Customer> findByEmail(String email) {
    return Optional.empty();
  }
  
  @Override
  @Transactional
  public Customer findOrSaveByEmail(String email) {
    return customerRepository.findByEmail(email).orElseGet(() -> {
      return save(new Customer(email));
    });
  }
  
}
