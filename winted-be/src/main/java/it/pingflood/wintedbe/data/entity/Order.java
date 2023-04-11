package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.UUID;

@Entity
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Table(name = "CUSTOMER_ORDER")
public class Order extends Auditable<String> implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID", nullable = false)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;
  
  @ManyToOne
  @JoinColumn(name = "CUSTOMER_ID")
  private Customer customer;
  @OneToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;
  @Column(name = "NOTE")
  private String note;
  @Column(name = "STATUS")
  private STATUS status = STATUS.OPEN;
  
  
  public enum STATUS {
    OPEN, CLOSED, ERROR
  }
}
