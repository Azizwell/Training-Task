package org.example.user_service.mapper;


import org.example.user_service.dto.UserDTO.UserDto;
import org.example.user_service.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

  public static UserDto toDto(User user) {

    return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getCompanyId());
  }

  public static User toEntity(UserDto userDto) {
    User user = new User();
    user.setFirstName(userDto.firstName());
    user.setLastName(userDto.lastName());
    user.setPhone(userDto.phone());
    user.setCompanyId(userDto.companyId());
    return user;
  }

  public static List<UserDto> toListDto(List<User> users) {
    List<UserDto> userDtos = new ArrayList<>();
    for (User user : users) {
      userDtos.add(toDto(user));
    }
    return userDtos;
  }


}
