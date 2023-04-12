package it.pingflood.wintedbe.data.service;

import it.pingflood.wintedbe.data.dto.request.ProductCreateRequest;
import it.pingflood.wintedbe.data.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
  Optional<Product> findById(UUID id);
  
  Product save(ProductCreateRequest productCreateRequest);
  
  List<Product> findAllPublic();
}
