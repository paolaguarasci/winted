package it.pingflood.wintedbe.data.dto;

import it.pingflood.wintedbe.data.entity.Customer;
import it.pingflood.wintedbe.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
  UUID id;
  Customer customer;
  Product product;
}
