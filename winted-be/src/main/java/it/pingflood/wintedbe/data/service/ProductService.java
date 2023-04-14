package it.pingflood.wintedbe.data.service;

import it.pingflood.wintedbe.data.dto.request.ProductCreateRequest;
import it.pingflood.wintedbe.data.dto.request.ProductModifyRequest;
import it.pingflood.wintedbe.data.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
  Optional<Product> findById(UUID id);
  
  Product save(ProductCreateRequest newProduct) throws Exception;
  
  List<Product> findAllPublic();
  
  List<Product> findAllByCustomerId(UUID customerId);
  
  Product update(UUID id, ProductModifyRequest updateProduct) throws Exception;
  
  void delete(UUID id) throws Exception;
}
