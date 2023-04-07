package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Category extends Auditable<String> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;
  
  private String name;
  
  @ManyToMany
  @ToString.Exclude
  private List<Category> children = new ArrayList<>();
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Category category = (Category) o;
    return getId() != null && Objects.equals(getId(), category.getId());
  }
  
  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
