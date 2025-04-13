package org.example.company_service.mapper;

import org.example.company_service.dto.DtoForCompany.CompanyDto;
import org.example.company_service.entity.Company;
import org.example.company_service.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapper {

  public static CompanyDto toDto(Company company) {
    List<Long> employee = new ArrayList<>();
    for (Employee userId : company.getUserId()) {
      employee.add(userId.getId());
    }
    return new CompanyDto(company.getId(), company.getName(), company.getBudget(), employee);
  }

  public static Company toEntity(CompanyDto companyDto) {
    Company company = new Company();
    company.setName(companyDto.name());
    company.setBudget(companyDto.budget());

    List<Employee> employee = new ArrayList<>();
    for (Long userId : companyDto.userIds()) {
      employee.add(new Employee(userId, company));
    }
    company.setUserId(employee);

    return company;
  }
}
