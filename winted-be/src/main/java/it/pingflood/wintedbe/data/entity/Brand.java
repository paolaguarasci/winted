package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Brand {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;
  
  private String name;
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Brand brand = (Brand) o;
    return getId() != null && Objects.equals(getId(), brand.getId());
  }
  
  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
