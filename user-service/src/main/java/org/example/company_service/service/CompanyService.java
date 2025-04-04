package org.example.company_service.service;

import org.example.company_service.client.CompanyClient;
import org.example.company_service.projection.CompanyResponse;
import org.example.company_service.projection.UserResponse;
import org.example.company_service.entity.User;
import org.example.company_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CompanyClient companyClient;

  public List<CompanyResponse> getAllCompanies() {
    List<User> users = userRepository.findAll();
    List<CompanyResponse> companies = companyClient.getAllCompanies();
    companies.forEach(company -> {
      List<UserResponse> userResponse = new ArrayList<>();
      company.getUserId().forEach(userId -> {
        users.forEach(user -> {
                  if (user.getId().equals(userId)) {
                    userResponse.add(new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getPhone()));
                  }
                }
        );
      });
      company.setUsers(userResponse);
    });


    return companies;
  }


}
