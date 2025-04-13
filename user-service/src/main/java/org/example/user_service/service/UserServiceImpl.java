package org.example.user_service.service;

import org.example.user_service.dto.UpdateUserDto;
import org.example.user_service.dto.UserDto;
import org.example.user_service.entity.User;
import org.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;


  @Override
  public ResponseEntity<?> getUsersByIds(List<Long> userIds) {
    List<User> users = userRepository.findAllById(userIds);
    return ResponseEntity.ok(users);
  }

  @Override
  public HttpEntity<?> postUser(UserDto userDto) {
    User build = new User(userDto.lastName(), userDto.firstName(), userDto.phone());

    userRepository.save(build);
    return ResponseEntity.ok("user created successfully");
  }

  @Override
  public HttpEntity<?> putUser(UpdateUserDto updateUserDto) {
    User foundUser = userRepository.findById(updateUserDto.id()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
    );
    foundUser.setFirstName(updateUserDto.firstName());
    foundUser.setLastName(updateUserDto.lastName());
    foundUser.setPhone(updateUserDto.phone());
    userRepository.save(foundUser);
    return ResponseEntity.ok("user updated successfully");
  }

  @Override
  public HttpEntity<?> deleteUser(Long id) {
    userRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid user")
    );
    userRepository.deleteById(id);
    return ResponseEntity.ok("user deleted successfully");
  }
}
