package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
  private String country;
  private String city;
  private String cap;
  private String addressLine1;
  private String addressLine2;
}
