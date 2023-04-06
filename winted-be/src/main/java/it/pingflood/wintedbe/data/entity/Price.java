package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Price {
  private Integer euro;
  private Integer cent;
}
