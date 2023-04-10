package it.pingflood.wintedbe.data.service;

import it.pingflood.wintedbe.data.entity.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
  Optional<Customer> findById(UUID id);
  
  Customer save(Customer customer);
  
  List<Customer> findAll();
  
  Optional<Customer> findByEmail(String email);
  
  Customer findOrSaveByEmail(String email);
}
