package it.pingflood.wintedbe.rest;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import it.pingflood.wintedbe.data.dto.ProductDTO;
import it.pingflood.wintedbe.data.entity.Product;
import it.pingflood.wintedbe.data.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "https://localhost:8082")
@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
  
  private final ProductService productService;
  
  public ProductController(ProductService productService) {
    this.productService = productService;
  }
  
  

  @GetMapping(value = "/{id}")
  @RateLimiter(name = "retryAndRateLimitExample")
  public ProductDTO findOne(@PathVariable UUID id) {
    String uuidstring = "57361225-26ac-46cc-a2c4-07c81f50f1f8";
    
    UUID uuidCablato = UUID.fromString(uuidstring);
    
    ProductDTO dto = new ProductDTO(uuidCablato, "test", "desc");
    
    if (id.equals(uuidCablato)) {
      return dto;
    }
    
    Product entity = this.productService.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    return convertToDto(entity);
  }
  
  @GetMapping
  public Collection<ProductDTO> findAll() {
    Iterable<Product> products = this.productService.findAll();
    List<ProductDTO> productDTOS = new ArrayList<>();
    products.forEach(p -> productDTOS.add(convertToDto(p)));
    return productDTOS;
  }
  
  protected ProductDTO convertToDto(Product entity) {
    ProductDTO dto = new ProductDTO(entity.getId(), entity.getTitle(), entity.getDescription());
    
    return dto;
  }
}
