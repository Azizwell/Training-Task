package org.example.company_service.controller;


import org.example.company_service.dto.UpdateUserDto;
import org.example.company_service.dto.UserDto;
import org.example.company_service.service.CompanyService;
import org.example.company_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private CompanyService companyService;

  @GetMapping("/all-users")
  public HttpEntity<?> getAllUsers() {
    return userService.getAllUsers();
  }


  @GetMapping("/users-company")
  public HttpEntity<?> getUserWithCompany() {
    return ResponseEntity.ok(companyService.getAllCompanies());
  }

  @PostMapping
  public HttpEntity<?> postUser(@RequestBody UserDto userDto) {
    return userService.postUser(userDto);
  }

  @PutMapping
  public HttpEntity<?> putUser(@RequestBody UpdateUserDto updateUserDto) {
    return userService.putUser(updateUserDto);
  }

  @DeleteMapping("/{id}")
  public HttpEntity<?> deleteUser(@PathVariable Long id) {
    return userService.deleteUser(id);
  }


}
