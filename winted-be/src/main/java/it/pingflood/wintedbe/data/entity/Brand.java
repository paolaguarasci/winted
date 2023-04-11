package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class Brand extends Auditable<String> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;
  
  private String name;
  
}
