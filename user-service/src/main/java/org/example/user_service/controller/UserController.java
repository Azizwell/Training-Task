package org.example.user_service.controller;


import org.example.user_service.dto.UpdateUserDto;
import org.example.user_service.dto.UserDto;
import org.example.user_service.service.CompanyService;
import org.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @Autowired
  private CompanyService companyService;

  @GetMapping("/filter")
  public HttpEntity<?> getUsersByIds(@RequestParam List<Long> userIds) {
    return userService.getUsersByIds(userIds);
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
