package it.pingflood.wintedbe.rest;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import it.pingflood.wintedbe.data.dto.ProductDTO;
import it.pingflood.wintedbe.data.dto.request.ProductCreateRequest;
import it.pingflood.wintedbe.data.dto.request.ProductModifyRequest;
import it.pingflood.wintedbe.data.service.CustomerService;
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
  
  private final CustomerService customerService;
  
  public ProductController(ProductService productService, CustomerService customerService) {
    this.productService = productService;
    this.customerService = customerService;
    this.modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
      .setFieldMatchingEnabled(true)
      .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
  }
  
  @GetMapping(value = "/product/{id}")
  @RateLimiter(name = "product-findOne")
  public ResponseEntity<ProductDTO> findOne(@PathVariable UUID id) {
    return ResponseEntity.ok(modelMapper.map(productService.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), ProductDTO.class));
  }
  
  @GetMapping(value = "/product")
  @RateLimiter(name = "product-findAll")
  public ResponseEntity<List<ProductDTO>> findAll() {
    return ResponseEntity.ok(productService.findAllPublic()
      .stream()
      .map(product -> modelMapper.map(product, ProductDTO.class))
      .toList());
  }
  @PostMapping(value = "/product")
  @RateLimiter(name = "product-saveOne")
  public ResponseEntity<ProductDTO> saveOne(@RequestBody ProductCreateRequest pcr) {
    try {
      return ResponseEntity.ok(modelMapper.map(productService.save(pcr), ProductDTO.class));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  @PutMapping(value = "/product/{id}")
  @RateLimiter(name = "product-modifyOne")
  public ResponseEntity<ProductDTO> modifyOne(@PathVariable UUID id, @RequestBody ProductModifyRequest pmr) {
    try {
      return ResponseEntity.ok(modelMapper.map(productService.update(id, pmr), ProductDTO.class));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
 
  @DeleteMapping(value = "/product/{id}")
  @RateLimiter(name = "product-deleteOne")
  public ResponseEntity deleteOne(@PathVariable UUID id) {
    try {
      productService.delete(id);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.noContent().build();
  }
}
