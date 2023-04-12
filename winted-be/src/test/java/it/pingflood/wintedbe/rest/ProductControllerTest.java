package it.pingflood.wintedbe.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import it.pingflood.wintedbe.data.entity.*;
import it.pingflood.wintedbe.data.entity.Product.PACK_DIMENSION;
import it.pingflood.wintedbe.data.entity.Product.STATUS;
import it.pingflood.wintedbe.data.service.CustomerService;
import it.pingflood.wintedbe.data.service.LogService;
import it.pingflood.wintedbe.data.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;
import java.util.UUID;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {
  @Autowired
  MockMvc mockMvc;
  ModelMapper modelMapper;
  @MockBean
  ProductService productService;
  @MockBean
  CustomerService customerService;
  @MockBean
  LogService logService;
  
  ObjectMapper mapper = new ObjectMapper();
  
  Product PRODUCT_1 = Product.builder()
  .id(UUID.fromString("b0bfeee8-a25b-4f88-a294-ecaaa99d86dd"))
  .brand(Brand.builder().name("brand1").build())
  .category(Category.builder().name("cat1").build())
  .color1(Color.builder().name("color1").valueCode("#83658D").build())
  .color2(Color.builder().name("color4").valueCode("#079EEA").build())
  .description("Culpa elit qui ea do deserunt occaecat proident consequat est enim non.")
  .packDimension(PACK_DIMENSION.BIG)
  .title("fireplace")
  .status(STATUS.VISIBLE)
  .price(Price.builder().euro(73).cent(0).build())
  .build();

  Product PRODUCT_2 = Product.builder()
  .id(UUID.fromString("9e2525e2-2f14-4e5a-a071-427e7367a673"))
  .brand(Brand.builder().name("brand2").build())
  .category(Category.builder().name("cat2").build())
  .color1(Color.builder().name("color2").valueCode("#EE0C61").build())
  .color2(Color.builder().name("color5").valueCode("#8CBF0D").build())
  .description("In nulla cupidatat anim aliquip occaecat consequat anim pariatur eu.")
  .packDimension(PACK_DIMENSION.BIG)
  .title("printed")
  .status(STATUS.HIDE)
  .price(Price.builder().euro(70).cent(0).build())
  .build();
  
  Product PRODUCT_3 = Product.builder()
  .id(UUID.fromString("ff82ee8b-7f75-489d-87b4-89c7d6dffc6b"))
  .brand(Brand.builder().name("brand3").build())
  .category(Category.builder().name("cat3").build())
  .color1(Color.builder().name("color3").valueCode("#9032D1").build())
  .color2(Color.builder().name("color6").valueCode("#393F86").build())
  .description("Occaecat officia consectetur sit ea et esse.")
  .packDimension(PACK_DIMENSION.BIG)
  .title("everywhere")
  .status(STATUS.VISIBLE)
  .price(Price.builder().euro(11).cent(0).build())
  .build();

  public ProductControllerTest() {
    this.modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
      .setFieldMatchingEnabled(true)
      .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
  }
  
  
//  @Test
//  void it_should_return_created_user() throws Exception {
//    ProductCreateRequest pcr = new ProductCreateRequest();
//    pcr.setTitle(PRODUCT_1.getTitle());
//    pcr.setDescription(PRODUCT_1.getDescription());
//
//    Mockito.when(productService.save(any(ProductCreateRequest.class))).thenReturn(PRODUCT_1);
//
//    mockMvc.perform(MockMvcRequestBuilders
//        .post("/api/products").with(csrf())
//        .content(mapper.writeValueAsString(pcr))
//        .contentType(MediaType.APPLICATION_JSON))
////      .andExpect(status().isOk())
//      .andExpect(jsonPath("$", hasSize(3)))
//      .andExpect((ResultMatcher) jsonPath("$[2].title", is(PRODUCT_3.getTitle())));
//  }
  
  
  @Test
  void it_should_return_find_user() throws Exception {
   
    Mockito.when(productService.findById(any(UUID.class))).thenReturn(Optional.of(PRODUCT_1));
    
    mockMvc.perform(MockMvcRequestBuilders
        .get("/api/products/" + PRODUCT_1.getId().toString()).with(csrf())
        .contentType(MediaType.APPLICATION_JSON))
//      .andExpect(status().isOk())
      .andExpect(jsonPath("$", hasSize(3)))
      .andExpect((ResultMatcher) jsonPath("$[2].title", is(PRODUCT_3.getTitle())));
  }
  
}
