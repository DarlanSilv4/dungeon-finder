package com.project.dungeonfinder.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.dungeonfinder.rpgtable.RpgTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "account")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(nullable = false, unique = true, length = 255)
  private String email;

  @Column(nullable = false, length = 255)
  private String password;

  @Column(name = "avatar_url", nullable = false, length = 500)
  private String avatarUrl;

  @CreationTimestamp
  @Column(name = "create_at")
  private Timestamp createAt;

  @ManyToMany(mappedBy = "members")
  @JsonBackReference
  private Set<RpgTable> rpgTables;

  @OneToMany
  @Column(name = "rpg_tables_created")
  private Set<RpgTable> rpgTablesCreated;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public Timestamp getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Timestamp createAt) {
    this.createAt = createAt;
  }

  public Set<RpgTable> getRpgTables() {
    return rpgTables;
  }

  public void setRpgTables(Set<RpgTable> rpgTables) {
    this.rpgTables = rpgTables;
  }

  public Set<RpgTable> getRpgTablesCreated() {
    return rpgTablesCreated;
  }

  public void setRpgTablesCreated(Set<RpgTable> rpgTablesCreated) {
    this.rpgTablesCreated = rpgTablesCreated;
  }
}
