package org.example.company_service.client;


import org.example.company_service.dto.FeignDto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {
  @GetMapping("/users/filter")
  List<UserResponse> getUsersByIds(@RequestParam("userIds") List<Long> userIds);
}
