package it.pingflood.wintedbe.rest;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import it.pingflood.wintedbe.data.dto.ProductDTO;
import it.pingflood.wintedbe.data.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class ProductController {
  
  private final ProductService productService;
  private final ModelMapper modelMapper;
  
  
  public ProductController(ProductService productService) {
    this.productService = productService;
    this.modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
      .setFieldMatchingEnabled(true)
      .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
  }
  
  @GetMapping(value = "/products/{id}")
  @RateLimiter(name = "product-findOne")
  public ResponseEntity<ProductDTO> findOne(@PathVariable UUID id) {
    return ResponseEntity.ok(modelMapper.map(productService.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), ProductDTO.class));
  }
  
  @GetMapping(value = "/products")
  @RateLimiter(name = "product-findAll")
  public ResponseEntity<List<ProductDTO>> findAll() {
    return ResponseEntity.ok(productService.findAll()
      .stream()
      .map(product -> modelMapper.map(product, ProductDTO.class))
      .toList());
  }
  
}
