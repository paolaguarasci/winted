package it.pingflood.wintedbe.data.service.impl;

import it.pingflood.wintedbe.data.dto.request.ProductCreateRequest;
import it.pingflood.wintedbe.data.dto.request.ProductModifyRequest;
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
  public Product save(ProductCreateRequest createRequest) {
    // TODO politica di salvataggio
    // Attenzione al caricamento delle immagini
    Product newProduct = Product.builder().build();
    return productRepository.save(newProduct);
  }
  
  @Override
  public List<Product> findAllPublic() {
    return productRepository.findAllPublic();
  }
  
  @Override
  public List<Product> findAllByCustomerId(UUID customerId) {
    return productRepository.findAllByOwner_Id(customerId);
  }
  
  @Override
  public Product update(UUID id, ProductModifyRequest modifyRequest) throws Exception{
    Product oldProduct = productRepository.findById(id).orElseThrow();
    // TODO politica di update
    return productRepository.save(oldProduct);
  }
  
  @Override
  public void delete(UUID id) {
  productRepository.delete(productRepository.findById(id).orElseThrow());
  }
}
