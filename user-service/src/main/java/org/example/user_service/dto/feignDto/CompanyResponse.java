package org.example.user_service.dto.feignDto;


import java.util.List;


public class CompanyResponse {
  private Long id;
  private String name;
  private Double budget;
  private List<Long> userIds;

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

  public List<Long> getUserIds() {
    return userIds;
  }

  public void setUserIds(List<Long> userId) {
    this.userIds = userId;
  }

  public CompanyResponse(Long id, String name, Double budget) {
    this.id = id;
    this.name = name;
    this.budget = budget;
  }

  @Override
  public String toString() {
    return "CompanyResponse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", budget=" + budget +
            ", userId=" + userIds +
            '}';
  }
}
