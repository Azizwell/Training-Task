package org.example.company_service.dto.FeignDto;

public class UserResponse {
  private Long id;
  private String firstName;
  private String lastName;
  private String phone;
  private Long companyId;


  // getter setter constructor
  public Long getCompanyId() {
    return companyId;
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


  public void setId(Long id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
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


  @Override
  public String toString() {
    return "UserResponse{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", phone='" + phone + '\'' +
            ", companyId=" + companyId +
            '}';
  }

}
