package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
public class Category extends Auditable<String> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;
  
  private String name;
  
  @ManyToMany
  @ToString.Exclude
  private List<Category> children = new ArrayList<>();
}
