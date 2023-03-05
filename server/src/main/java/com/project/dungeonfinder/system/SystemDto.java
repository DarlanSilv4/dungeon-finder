package com.project.dungeonfinder.system;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SystemDto {

  @NotBlank
  @Size(max = 50)
  private String name;

  @Size(max = 20)
  private String abbreviation;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }
}
