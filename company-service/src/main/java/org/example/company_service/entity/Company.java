package org.example.company_service.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name", nullable = false, length = 255)
  private String name;
  @Column(name = "budget", nullable = false)
  private Double budget;


  @OneToMany(
          mappedBy = "company",
          cascade = CascadeType.ALL, // все операции (удаление, обновление) переходят на сотрудников
          orphanRemoval = true     // если сотрудник исключается из коллекции, он удаляется из БД
  )
  private List<Employee> employeesIds;

  // getter setter constructor
  public Company(String name, Double budget, List<Employee> employeesIds) {
    this.name = name;
    this.budget = budget;
    this.employeesIds = employeesIds;
  }

  public Company(String name, Double budget) {
    this.name = name;
    this.budget = budget;
  }

  public Company() {

  }

  public void setUserId(List<Employee> employeesIds) {
    this.employeesIds = employeesIds;
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

  public List<Employee> getUserId() {
    return employeesIds;
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

  @Override
  public String toString() {
    return "Company{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", budget=" + budget +
            ", employeesIds=" + employeesIds +
            '}';
  }
}
