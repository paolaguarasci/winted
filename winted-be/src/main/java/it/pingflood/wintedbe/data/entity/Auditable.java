package it.pingflood.wintedbe.data.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {
  
  @CreatedBy
  protected T createdBy;
  
  @CreatedDate
  protected LocalDateTime createdDate;
  
  @LastModifiedBy
  protected T lastModifiedBy;
  
  @LastModifiedDate
  protected LocalDateTime lastModifiedDate;
  
  public T getCreatedBy() {
    return createdBy;
  }
  
  public void setCreatedBy(T createdBy) {
    this.createdBy = createdBy;
  }
  
  public LocalDateTime getCreatedDate() {
    return createdDate;
  }
  
  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }
  
  public T getLastModifiedBy() {
    return lastModifiedBy;
  }
  
  public void setLastModifiedBy(T lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
  
  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }
  
  public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }
}
