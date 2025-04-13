package org.example.user_service.projection;

public class UserResponse {
  private Long id;
  private String firstName;
  private String lastName;
  private String phone;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserResponse() {
  }

  public UserResponse(Long id, String firstName, String lastName, String phone) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "UserResponse{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }
}
