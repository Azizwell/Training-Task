package org.example.user_service.service;

import org.example.user_service.dto.UpdateUserDto;
import org.example.user_service.dto.UserDto;
import org.springframework.http.HttpEntity;

import java.util.List;


public interface UserService {

  HttpEntity<?> getUsersByIds(List<Long> userIds);

  HttpEntity<?> postUser(UserDto userDto);

  HttpEntity<?> putUser(UpdateUserDto updateUserDto);

  HttpEntity<?> deleteUser(Long id);

}
