package it.pingflood.wintedbe.rest;

import it.pingflood.wintedbe.data.dto.ProductDTO;
import it.pingflood.wintedbe.data.entity.Product;
import it.pingflood.wintedbe.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
  
  private final ProductService productService;
  
  public ProductController(ProductService productService) {
    this.productService = productService;
  }
  
  
  @CrossOrigin(origins = "http://localhost:8082")
  @GetMapping(value = "/{id}")
  public ProductDTO findOne(@PathVariable UUID id) {
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
