package org.example.company_service.config;

import org.example.company_service.entity.Company;
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
    List<Long> TexNoUserIds = new ArrayList<>();
    TexNoUserIds.add(1L);
    TexNoUserIds.add(2L);
    TexNoUserIds.add(3L);
    List<Long> PromoPartyUserIds = new ArrayList<>();
    PromoPartyUserIds.add(4L);
    PromoPartyUserIds.add(5L);

    if (all.isEmpty()) {
      companyRepository.saveAll(List.of(
              new Company("TexNo", 100.0, TexNoUserIds),
              new Company("PromoParty", 500.0, PromoPartyUserIds)
      ));
    }


  }
}
