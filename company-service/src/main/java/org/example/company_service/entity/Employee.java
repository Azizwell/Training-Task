package org.example.company_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
  @Id
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "company_id")
  private Company company;

  // Конструктор с параметрами
  public Employee() {
  }

  public Employee(Long id, Company company) {
    this.id = id;
    this.company = company;
  }

  public Employee(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "id=" + id +
            '}';
  }

}
