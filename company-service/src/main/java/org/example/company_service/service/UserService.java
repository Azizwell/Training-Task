package org.example.company_service.service;

import org.example.company_service.client.UserClient;
import org.example.company_service.dto.CompanyUserDto;
import org.example.company_service.dto.FeignDto.UserResponse;
import org.example.company_service.entity.Company;
import org.example.company_service.entity.Employee;
import org.example.company_service.projection.CompanyResponseProjection;
import org.example.company_service.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
  @Autowired
  private UserClient userClient;
  @Autowired
  private CompanyRepository companyRepository;

  private final Logger log = LoggerFactory.getLogger(UserService.class);

  // тут реализовано передача user+company
  public CompanyResponseProjection getCompanyById(Long id) {
    List<CompanyUserDto> companyUsers = new ArrayList<>();
    List<Long> findUserIds = new ArrayList<>();
    Company findCompany = companyRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company не найдено")
    );

    for (Employee employee : findCompany.getUserId()) {
      findUserIds.add(employee.getId());
    }

    if (!findUserIds.isEmpty()) {
      List<UserResponse> users = userClient.getUsersByIds(findUserIds);

      for (UserResponse user : users) {
        companyUsers.add(
                new CompanyUserDto(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getPhone()));
      }

      CompanyResponseProjection companyResponseProjection = new CompanyResponseProjection(findCompany.getId(), findCompany.getName(), findCompany.getBudget(), companyUsers);
      log.info("Возврашено выбранный company с сотрудниками: {}", companyResponseProjection);
      return companyResponseProjection;

    } else {
      log.info("ползовател не найдено либо пустой: {}", findCompany);
      return new CompanyResponseProjection(findCompany.getId(), findCompany.getName(), findCompany.getBudget(), null);
    }

  }


}
