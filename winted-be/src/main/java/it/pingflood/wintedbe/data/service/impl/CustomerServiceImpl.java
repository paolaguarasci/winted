package it.pingflood.wintedbe.data.service.impl;

import it.pingflood.wintedbe.data.entity.Customer;
import it.pingflood.wintedbe.data.repo.CustomerRepository;
import it.pingflood.wintedbe.data.service.CustomerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

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
  public Customer getUserInfo() {

    var authentication = SecurityContextHolder.getContext().getAuthentication();
    var jwt = (Jwt) authentication.getPrincipal();
    var username = (String) jwt.getClaims().get("preferred_username");
    var email = (String) jwt.getClaims().get("email");

    return customerRepository.findByEmail(email).orElseGet(() -> save(Customer.builder().email(email).username(username).build()));
  }
  
}
