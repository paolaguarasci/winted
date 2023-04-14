package it.pingflood.wintedbe.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO Completare con tutti i campi
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductModifyRequest {
  String id;
  String title;
  String description;
}
