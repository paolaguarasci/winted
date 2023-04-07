package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Product extends Auditable<String> implements Serializable {
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @ManyToOne
  @JoinColumn(name = "OWNER_ID", referencedColumnName = "ID")
  private Customer owner;
  @Column(name = "TITLE", nullable = false)
  private String title;
  @Column(name = "DESCRIPTION", nullable = false)
  private String description;
  @Embedded
  private Price price;
  @ManyToOne
  @JoinColumn(name = "CATEGORY")
  private Category category;
  @ManyToOne
  @JoinColumn(name = "COLOR1")
  private Color color1;
  @ManyToOne
  @JoinColumn(name = "COLOR2")
  private Color color2;
  @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  private List<Photo> photos;
  @Enumerated(EnumType.STRING)
  private PACK_DIMENSION packDimension;
  @Enumerated(EnumType.STRING)
  private CONDITION wearCondition;
  @ManyToOne
  @JoinColumn(name = "BRAND_ID")
  private Brand brand;
  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private STATUS status = STATUS.VISIBLE;
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Product product = (Product) o;
    return getId() != null && Objects.equals(getId(), product.getId());
  }
  
  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
  
  public enum CONDITION {
    NEW_WITH_LABEL, NEW_NO_LABEL, OPTIMUM, GOOD, AVERAGE
  }
  
  public enum PACK_DIMENSION {
    SMALL, MEDIUM, BIG
  }
  
  public enum STATUS {
    VISIBLE, HIDE
  }
}
