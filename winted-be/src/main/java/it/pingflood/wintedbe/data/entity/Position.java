package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Position {
  private String city;
  
  private String country;
  private Boolean showCity = true;
}
