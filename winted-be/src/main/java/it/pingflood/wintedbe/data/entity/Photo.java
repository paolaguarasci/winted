package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Photo {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID", nullable = false)
  private UUID id;
  
  private byte[] image;
  
  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
  private Product product;
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Photo photo = (Photo) o;
    return getId() != null && Objects.equals(getId(), photo.getId());
  }
  
  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
