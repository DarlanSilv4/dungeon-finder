package com.project.dungeonfinder.system;

import com.project.dungeonfinder.rpgtable.RpgTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "system")
public class System implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, length = 50)
  private String name;

  @OneToMany
  @Column(name = "rpg_tables")
  private List<RpgTable> rpgTables;

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

  public List<RpgTable> getRpgTables() {
    return this.rpgTables;
  }

  public void setRpgTables(List<RpgTable> rpgTables) {
    this.rpgTables = rpgTables;
  }
}
