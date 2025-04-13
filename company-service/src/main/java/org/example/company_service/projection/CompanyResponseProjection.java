package org.example.company_service.projection;

import org.example.company_service.dto.CompanyUserDto;

import java.util.List;

public class CompanyResponseProjection {
  private Long id;
  private String name;
  private Double budget;
  private List<CompanyUserDto> users;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getBudget() {
    return budget;
  }

  public void setBudget(Double budget) {
    this.budget = budget;
  }

  public List<CompanyUserDto> getUsers() {
    return users;
  }

  public void setUsers(List<CompanyUserDto> users) {
    this.users = users;
  }

  public CompanyResponseProjection(Long id, String name, Double budget, List<CompanyUserDto> users) {
    this.id = id;
    this.name = name;
    this.budget = budget;
    this.users = users;
  }

  @Override
  public String toString() {
    return "CompanyResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", budget=" + budget +
            ", users=" + users +
            '}';
  }
}
