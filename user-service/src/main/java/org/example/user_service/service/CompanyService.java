package org.example.user_service.service;

import org.example.user_service.client.CompanyClient;
import org.example.user_service.dto.CompanyResponseDto;
import org.example.user_service.dto.UserResponseDto;
import org.example.user_service.dto.feignDto.CompanyResponse;
import org.example.user_service.entity.User;
import org.example.user_service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CompanyClient companyClient;

  private final Logger log = LoggerFactory.getLogger(CompanyService.class);


  public UserResponseDto getUserWithCompany(Long id) {
    User users = userRepository.findById(id).orElseThrow(
            () -> new RuntimeException("сотрудник с id " + id + " не найдено")
    );

    CompanyResponse companies = companyClient.getCompaniesById(users.getCompanyId());
    CompanyResponseDto companyResponseDto = new CompanyResponseDto(companies.getId(), companies.getName(), companies.getBudget());
    UserResponseDto userResponseDto = new UserResponseDto(users.getId(), users.getFirstName()
            , users.getLastName(), users.getPhone(), companyResponseDto);

    log.info("Возврашено выбранный сотрудник с компанями: {}", userResponseDto);

    return userResponseDto;
  }


}
