package it.pingflood.wintedbe.data.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

public class DefaultOAuth2 implements OAuth2User, Serializable {
  private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
  
  private final Set<GrantedAuthority> authorities;
  
  private final Map<String, Object> attributes;
  
  private final String nameAttributeKey;
  
  public DefaultOAuth2(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes,
                       String nameAttributeKey) {
    Assert.notEmpty(attributes, "attributes cannot be empty");
    Assert.hasText(nameAttributeKey, "nameAttributeKey cannot be empty");
    if (!attributes.containsKey(nameAttributeKey)) {
      throw new IllegalArgumentException("Missing attribute '" + nameAttributeKey + "' in attributes");
    }
    this.authorities = (authorities != null)
      ? Collections.unmodifiableSet(new LinkedHashSet<>(this.sortAuthorities(authorities)))
      : Collections.unmodifiableSet(new LinkedHashSet<>(AuthorityUtils.NO_AUTHORITIES));
    this.attributes = Collections.unmodifiableMap(new LinkedHashMap<>(attributes));
    this.nameAttributeKey = nameAttributeKey;
  }
  
  @Override
  public String getName() {
    return this.getAttribute(this.nameAttributeKey).toString();
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }
  
  @Override
  public Map<String, Object> getAttributes() {
    return this.attributes;
  }
  
  private Set<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
    SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(
      Comparator.comparing(GrantedAuthority::getAuthority));
    sortedAuthorities.addAll(authorities);
    return sortedAuthorities;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || this.getClass() != obj.getClass()) {
      return false;
    }
    DefaultOAuth2 that = (DefaultOAuth2) obj;
    if (!this.getName().equals(that.getName())) {
      return false;
    }
    if (!this.getAuthorities().equals(that.getAuthorities())) {
      return false;
    }
    return this.getAttributes().equals(that.getAttributes());
  }
  
  @Override
  public int hashCode() {
    int result = this.getName().hashCode();
    result = 31 * result + this.getAuthorities().hashCode();
    result = 31 * result + this.getAttributes().hashCode();
    return result;
  }
  
  @Override
  public String toString() {
    String sb = "Name: [" +
      this.getName() +
      "], Granted Authorities: [" +
      getAuthorities() +
      "], User Attributes: [" +
      getAttributes() +
      "]";
    return sb;
  }
  
}
