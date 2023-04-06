package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.TemporalType.DATE;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Customer {
  public enum GENDER {
    FEMALE, MALE, OTHER
  }
  @Id
  @Column(name = "ID", nullable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  
  @Column(name = "USERNAME", unique = true)
  private String username;
  
  @Column(name = "EMAIL", unique = true)
  private String email;
  @Column(name = "FIRST_NAME")
  private String firstName;
  @Column(name = "SECOND_NAME")
  private String secondName;
  
  @Column(name = "GENDER")
  @Enumerated(EnumType.STRING)
  private GENDER gender;
  
  @Column(name = "PHONE_NUMBER")
  private String phoneNumber;
  
  @Column(name = "HOLIDAY_MODE")
  private Boolean holidayMode;
  
  @Column(name = "BIRTHDATE")
  @Temporal(DATE)
  private LocalDate birthDate;
  
  @Column(name = "BIO")
  private String bio;
  
  @Column(name="LAST_VISIT")
  private LocalDateTime lastVisit;
  
  
  @Lob
  @Column(name="AVATAR")
  @Basic(fetch = FetchType.LAZY)
  @ToString.Exclude
  private byte[] avatar;
  
  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "country", column = @Column(name = "POSITION_COUNTRY")),
    @AttributeOverride(name = "city", column = @Column(name = "POSITION_CITY")),
    @AttributeOverride(name = "showCity", column = @Column(name = "POSITION_SHOW_CITY"))
  })
  private Position position;
  
  @Embedded
//  @AttributeOverrides({
//    @AttributeOverride(name = "country", column = @Column(name = "POSITION_COUNTRY")),
//    @AttributeOverride(name = "city", column = @Column(name = "POSITION_CITY")),
//    @AttributeOverride(name = "showCity", column = @Column(name = "POSITION_SHOW_CITY"))
//  })
  private Address address;
  
  @Enumerated(EnumType.STRING)
  private Lang lang;
  
  @ManyToMany
  @JoinTable(
    name = "PREFERED",
    joinColumns = @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
  )
  private List<Product> prefered;
  
  @OneToMany(mappedBy = "owner")
  private List<Product> wardrobe; // my product
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Customer customer = (Customer) o;
    return getId() != null && Objects.equals(getId(), customer.getId());
  }
  
  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
