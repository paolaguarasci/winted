package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Log {
  
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "AT")
  private LocalDateTime at = LocalDateTime.now();
  @Column(name = "METHODS")
  @Enumerated(EnumType.STRING)
  private REQUEST_METHOD method;
  
  @Column(name = "URI")
  private String uri;
  
  @Column(name = "MESSAGE")
  private String message;
  
  @Column(name = "STATUS")
  private Integer status;
  
  @Column(name = "CUSTOMER_ID")
  private String customer_id;
  
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Log log)) return false;
    return new EqualsBuilder().append(id, log.id).isEquals();
  }
  
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(id).toHashCode();
  }
  
  /*
   * id
   * timestamp
   * il metodo chiamato
   * il percorso dell’API
   * l’id dell’utente
   * lo status della request
   * */
  
  public enum REQUEST_METHOD {
    GET, PUT, POST, PATH, OPTION, DELETE
  }
  
  public enum REQUEST_STATUS {
    OK, FAILED
  }
}
