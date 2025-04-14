package org.example.user_service.controller;


import jakarta.validation.Valid;
import org.example.user_service.dto.UserDTO.UpdateUserDto;
import org.example.user_service.dto.UserDTO.UserDto;
import org.example.user_service.dto.UserResponseDto;
import org.example.user_service.service.CompanyService;
import org.example.user_service.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  private final Logger log = LoggerFactory.getLogger(UserController.class);

  @GetMapping("/filter")
  public ResponseEntity<List<UserDto>> getUsersByIds(@RequestParam List<Long> userIds) {
    log.info("Получено запрос на получчение список ползователей по ид {}", userIds);
    return userService.getUsersByIds(userIds);
  }


  @GetMapping("/users-company/{id}")
  public ResponseEntity<UserResponseDto> getUserWithCompany(@PathVariable Long id) {
    log.info("Получено запрос на получчение  ползователя по ид {}", id);
    return ResponseEntity.ok(companyService.getUserWithCompany(id));
  }

  @PostMapping
  public ResponseEntity<UserDto> postUser(@Valid @RequestBody UserDto userDto) {
    log.info("Получено запрос  создание  ползователя  {}", userDto);
    return userService.postUser(userDto);
  }

  @PutMapping
  public ResponseEntity<UserDto> putUser(@Valid @RequestBody UpdateUserDto updateUserDto) {
    log.info("Получено запрос  изменения  ползователя  {}", updateUserDto);
    return userService.putUser(updateUserDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    log.info("Получено запрос  удаление  ползователя по ид {}", id);
    return userService.deleteUser(id);
  }


}
