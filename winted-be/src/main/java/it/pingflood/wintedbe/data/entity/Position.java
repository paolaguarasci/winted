package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Position {
  private String city;
  
  private String country;
  
  @Column(name = "SHOW_CITY", columnDefinition = "tinyint(1)")
  private Boolean showCity = true;
}
