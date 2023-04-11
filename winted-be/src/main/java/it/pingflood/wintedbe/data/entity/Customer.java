package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.TemporalType.DATE;

@Entity
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Customer extends Auditable<String> implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID", nullable = false)
  @JdbcTypeCode(SqlTypes.VARCHAR)
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
  
  @Column(name = "HOLIDAY_MODE", columnDefinition = "tinyint(1)")
  private Boolean holidayMode;
  
  @Column(name = "BIRTHDATE")
  @Temporal(DATE)
  private LocalDate birthDate;
  @Column(name = "BIO")
  private String bio;
  @Column(name = "LAST_VISIT")
  private LocalDateTime lastVisit;
  
  @Lob
  @Column(name = "AVATAR")
  @Basic(fetch = FetchType.LAZY)
  @ToString.Exclude
  private byte[] avatar;
  
  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "country", column = @Column(name = "POSITION_COUNTRY")),
    @AttributeOverride(name = "city", column = @Column(name = "POSITION_CITY")),
    @AttributeOverride(name = "showCity", column = @Column(name = "POSITION_SHOW_CITY", columnDefinition = "tinyint(1)"))
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
  @ToString.Exclude
  private List<Product> prefered;
  @OneToMany(mappedBy = "owner")
  @ToString.Exclude
  private List<Product> wardrobe; // my product
  
  
  public Customer(String email) {
    this.email = email;
  }
  
  public enum GENDER {
    FEMALE, MALE, OTHER
  }
}
