package org.example.company_service.service;

import org.example.company_service.dto.UpdateUserDto;
import org.example.company_service.dto.UserDto;
import org.springframework.http.HttpEntity;


public interface UserService {

  HttpEntity<?> getAllUsers();

  HttpEntity<?> postUser(UserDto userDto);

  HttpEntity<?> putUser(UpdateUserDto updateUserDto);

  HttpEntity<?> deleteUser(Long id);
}
