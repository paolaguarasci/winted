package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "CUSTOMER_ORDER")
public class Order {
  
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
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
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Order order = (Order) o;
    return getId() != null && Objects.equals(getId(), order.getId());
  }
  
  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
  
  public enum STATUS {
    OPEN, CLOSED, ERROR
  }
}
