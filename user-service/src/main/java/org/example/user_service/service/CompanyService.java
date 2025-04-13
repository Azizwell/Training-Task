package org.example.user_service.service;

import org.example.user_service.client.CompanyClient;
import org.example.user_service.entity.User;
import org.example.user_service.projection.CompanyResponse;
import org.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CompanyClient companyClient;

  public CompanyResponse getAllCompanies() {
    List<User> users = userRepository.findAll();
    CompanyResponse companies = companyClient.getCompaniesById(1L);


    return companies;
  }


}
