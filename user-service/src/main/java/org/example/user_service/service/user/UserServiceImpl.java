package org.example.user_service.service.user;

import org.example.user_service.dto.UserDTO.UpdateUserDto;
import org.example.user_service.dto.UserDTO.UserDto;
import org.example.user_service.entity.User;
import org.example.user_service.mapper.UserMapper;
import org.example.user_service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public ResponseEntity<List<UserDto>> getUsersByIds(List<Long> userIds) {
    List<User> users = userRepository.findAllById(userIds);
    List<UserDto> listDto = UserMapper.toListDto(users);
    log.info("Возвращено найденный список ползователей {}", listDto);
    return ResponseEntity.ok(listDto);
  }

  @Override
  public ResponseEntity<UserDto> postUser(UserDto userDto) {
    User build = new User(userDto.lastName(), userDto.firstName(), userDto.phone(), userDto.companyId());
    UserDto Dto = UserMapper.toDto(userRepository.save(build));
    log.info("Возвращено созданный ползователь {}", Dto);
    return ResponseEntity.ok(Dto);
  }

  @Override
  public ResponseEntity<UserDto> putUser(UpdateUserDto updateUserDto) {
    User foundUser = userRepository.findById(updateUserDto.id()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found")
    );
    foundUser.setFirstName(updateUserDto.firstName());
    foundUser.setLastName(updateUserDto.lastName());
    foundUser.setPhone(updateUserDto.phone());
    foundUser.setCompanyId(updateUserDto.companyId());

    UserDto dto = UserMapper.toDto(userRepository.save(foundUser));
    log.info("Возвращено измененный ползователь {}", dto);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<String> deleteUser(Long id) {
    userRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "недействительный пользователь")
    );
    userRepository.deleteById(id);
    log.info("Удалено найденный ползователь по ид {}", id);
    return ResponseEntity.ok("user deleted successfully");
  }
}
