package org.example.user_service.service.user;

import org.example.user_service.dto.UserDTO.UpdateUserDto;
import org.example.user_service.dto.UserDTO.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {

  ResponseEntity<List<UserDto>> getUsersByIds(List<Long> userIds);

  ResponseEntity<UserDto> postUser(UserDto userDto);

  ResponseEntity<UserDto> putUser(UpdateUserDto updateUserDto);

  ResponseEntity<String> deleteUser(Long id);

}
