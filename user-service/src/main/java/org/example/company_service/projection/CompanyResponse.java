package org.example.company_service.projection;

import java.util.ArrayList;
import java.util.List;


public class CompanyResponse {
  private Long id;
  private String name;
  private Double budget;
  private List<Long> userId = new ArrayList<>();
  private List<UserResponse> users;

  //getter setter constructor
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

  public List<Long> getUserId() {
    return userId;
  }

  public void setUserId(List<Long> userId) {
    this.userId = userId;
  }

  public List<UserResponse> getUsers() {
    return users;
  }

  public void setUsers(List<UserResponse> users) {
    this.users = users;
  }

  public CompanyResponse(Long id, String name, Double budget, List<UserResponse> users) {
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
            ", userId=" + userId +
            ", users=" + users +
            '}';
  }
}
