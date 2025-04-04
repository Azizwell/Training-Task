package org.example.company_service.service;

import org.example.company_service.client.UserClient;
import org.example.company_service.entity.Company;
import org.example.company_service.projection.UserResponse;
import org.example.company_service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
  @Autowired
  private UserClient userClient;
  @Autowired
  private CompanyRepository companyRepository;

  // тут реализовано передача user+company
  public List<UserResponse> getAllUsers() {
    List<UserResponse> users = userClient.getUsersByCompany();
    List<Company> companies = companyRepository.findAll();

    users.forEach(userResponse -> {
              companies.stream()
                      .filter(company -> company.getId().equals(userResponse.getCompanyId()))
                      .findFirst()
                      .ifPresent(userResponse::setCompany);
            }
    );
    return users;
  }


}
