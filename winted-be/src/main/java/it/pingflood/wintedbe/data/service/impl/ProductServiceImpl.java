package it.pingflood.wintedbe.data.service.impl;

import it.pingflood.wintedbe.data.dto.request.ProductCreateRequest;
import it.pingflood.wintedbe.data.entity.Product;
import it.pingflood.wintedbe.data.repo.ProductRepository;
import it.pingflood.wintedbe.data.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
  
  private final ProductRepository productRepository;
  
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
  
  @Override
  public Optional<Product> findById(UUID id) {
    return productRepository.findById(id);
  }
  
  @Override
  public Product save(ProductCreateRequest productCreateRequest) {
    
    // return productRepository.save(product);
    return null;
  }
  
  @Override
  public List<Product> findAllPublic() {
    return productRepository.findAll();
  }
}
