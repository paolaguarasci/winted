package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends Auditable<String> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID", nullable = false)
  @JdbcTypeCode(SqlTypes.VARCHAR)
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
