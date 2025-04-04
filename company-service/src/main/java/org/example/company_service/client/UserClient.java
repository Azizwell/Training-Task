package org.example.company_service.client;


import org.example.company_service.projection.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user-service")
public interface UserClient {
  @GetMapping("/users/all-users")
  List<UserResponse> getUsersByCompany();

}
