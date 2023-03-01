package com.project.dungeonfinder.rpgtable;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "rpg_table")
public class RpgTable implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, length = 50)
  private String name;

  @Column(length = 280)
  private String description;

  @Column(name = "is_oneshot", nullable = false)
  private boolean isOneShot;

  @ElementCollection(fetch = FetchType.LAZY)
  @Enumerated(EnumType.ORDINAL)
  @JoinTable(name = "rpg_table_days", joinColumns = @JoinColumn(name = "id"))
  @Column(name = "day")
  private List<DayOfWeek> days;

  @Column(name = "platform_url", length = 280)
  private String platformUrl;

  @Column(name = "is_open", nullable = false)
  private boolean isOpen;

  @CreationTimestamp
  @Column(
    name = "create_at",
    nullable = false,
    updatable = false,
    insertable = false
  )
  private Timestamp createAt;

  public UUID getId() {
    return this.id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isOneShot() {
    return this.isOneShot;
  }

  public void setOneShot(boolean isOneShot) {
    this.isOneShot = isOneShot;
  }

  public List<DayOfWeek> getDays() {
    return this.days;
  }

  public void setDays(List<DayOfWeek> days) {
    this.days = days;
  }

  public String getPlatformUrl() {
    return this.platformUrl;
  }

  public void setPlatformUrl(String platformUrl) {
    this.platformUrl = platformUrl;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean isOpen) {
    this.isOpen = isOpen;
  }

  public Timestamp getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Timestamp createAt) {
    this.createAt = createAt;
  }
}
