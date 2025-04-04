package org.example.company_service.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Double budget;

  @ElementCollection
  private List<Long> userId = new ArrayList<>();

// getter setter constructor
  public Company(String name, Double budget, List<Long> userId) {
    this.name = name;
    this.budget = budget;
    this.userId = userId;
  }

  public Company(String name, Double budget) {
    this.name = name;
    this.budget = budget;
  }

  public Company() {

  }

  public void setUserId(List<Long> userId) {
    this.userId = userId;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getBudget() {
    return budget;
  }

  public List<Long> getUserId() {
    return userId;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBudget(Double budget) {
    this.budget = budget;
  }
}
