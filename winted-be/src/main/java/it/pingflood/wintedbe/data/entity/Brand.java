package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Brand extends Auditable<String> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;
  
  private String name;
  
}
