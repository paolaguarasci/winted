package it.pingflood.wintedbe.data.vo;

import lombok.NoArgsConstructor;
import lombok.Value;

// TODO si rompe senza il costruttore senza argomenti, trovare una soluzione!

@Value
@NoArgsConstructor(force = true)
public class ProductTitle {
  String value;
  public ProductTitle(String value) {
    // TODO Validazione
    this.value = value;
  }
  
}
