package org.example.company_service.config;

import org.example.company_service.entity.Company;
import org.example.company_service.entity.Employee;
import org.example.company_service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
  @Autowired
  CompanyRepository companyRepository;


  @Override
  public void run(String... args) throws Exception {
    List<Company> all = companyRepository.findAll();

    if (all.isEmpty()) {
      Company company1 = companyRepository.save(new Company("Texno", 200.0));
      Company company2 = companyRepository.save(new Company("Moto", 500.0));
      List<Employee> TexNoUserIds = new ArrayList<>();
      TexNoUserIds.add(new Employee(1L, company1));
      TexNoUserIds.add(new Employee(2L, company1));
      TexNoUserIds.add(new Employee(3L, company1));
      company1.setUserId(TexNoUserIds);

      List<Employee> MotoUserIds = new ArrayList<>();
      MotoUserIds.add(new Employee(4L, company2));
      MotoUserIds.add(new Employee(5L, company2));
      company2.setUserId(MotoUserIds);

      companyRepository.save(company1);
      companyRepository.save(company2);

    }
  }
}
