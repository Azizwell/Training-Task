package org.example.company_service.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String phone;
  private Long companyId;

  //getter setter constructor
  public User() {

  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public User(String firstName, String lastName, String phone, Long companyId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.companyId = companyId;
  }

  public User(String firstName, String lastName, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;

  }
}
