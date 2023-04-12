package it.pingflood.wintedbe.rest;

import it.pingflood.wintedbe.data.dto.request.ProductCreateRequest;
import it.pingflood.wintedbe.data.entity.*;
import it.pingflood.wintedbe.data.repo.ProductRepository;
import it.pingflood.wintedbe.data.service.CustomerService;
import it.pingflood.wintedbe.data.service.LogService;
import it.pingflood.wintedbe.data.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(value = {"test"})
class ProductServiceTests {
  @Mock
  ProductRepository productRepository;
  
  @Mock
  CustomerService customerService;
  
  @Mock
  LogService logService;
  
  @InjectMocks
  ProductService productService;
  
  Product PRODUCT_1 = Product.builder()
    .brand(Brand.builder().name("brand1").build())
    .category(Category.builder().name("cat1").build())
    .color1(Color.builder().name("color1").valueCode("#83658D").build())
    .color2(Color.builder().name("color4").valueCode("#079EEA").build())
    .description("Culpa elit qui ea do deserunt occaecat proident consequat est enim non.")
    .packDimension(Product.PACK_DIMENSION.BIG)
    .title("fireplace")
    .status(Product.STATUS.VISIBLE)
    .price(Price.builder().euro(73).cent(0).build())
    .build();
  
  Product PRODUCT_2 = Product.builder()
    .brand(Brand.builder().name("brand2").build())
    .category(Category.builder().name("cat2").build())
    .color1(Color.builder().name("color2").valueCode("#EE0C61").build())
    .color2(Color.builder().name("color5").valueCode("#8CBF0D").build())
    .description("In nulla cupidatat anim aliquip occaecat consequat anim pariatur eu.")
    .packDimension(Product.PACK_DIMENSION.BIG)
    .title("printed")
    .status(Product.STATUS.HIDE)
    .price(Price.builder().euro(70).cent(0).build())
    .build();
  
  Product PRODUCT_3 = Product.builder()
    .brand(Brand.builder().name("brand3").build())
    .category(Category.builder().name("cat3").build())
    .color1(Color.builder().name("color3").valueCode("#9032D1").build())
    .color2(Color.builder().name("color6").valueCode("#393F86").build())
    .description("Occaecat officia consectetur sit ea et esse.")
    .packDimension(Product.PACK_DIMENSION.BIG)
    .title("everywhere")
    .status(Product.STATUS.VISIBLE)
    .price(Price.builder().euro(11).cent(0).build())
    .build();
  
  
  @Test
  public void when_save_product_it_should_be_return_product() {
    ProductCreateRequest productCreateRequest = new ProductCreateRequest();
    Mockito.when(productRepository.save(any(Product.class))).thenReturn(new Product());
    Product created = productService.save(productCreateRequest);
  }
  
}
