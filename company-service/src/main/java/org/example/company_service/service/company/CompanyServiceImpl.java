package org.example.company_service.service.company;

import org.example.company_service.dto.CompanyDto;
import org.example.company_service.dto.UpdateCompanyDto;
import org.example.company_service.entity.Company;
import org.example.company_service.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CompanyServiceImpl implements CompanyService {
  @Autowired
  private CompanyRepository companyRepository;

  @Override
  public ResponseEntity<?> getAllCompany() {
    return ResponseEntity.ok(companyRepository.findAll());
  }

  @Override
  public HttpEntity<?> postCompany(CompanyDto companyDto) {
    Company companyBuild = new Company(companyDto.name(), companyDto.budget());
    companyRepository.save(companyBuild);
    return ResponseEntity.ok("company created successfully");
  }

  @Override
  public HttpEntity<?> putCompany(UpdateCompanyDto updateCompanyDto) {
    Company companyFound = companyRepository.findById(updateCompanyDto.id()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company not found")
    );
    companyFound.setName(updateCompanyDto.name());
    companyFound.setBudget(updateCompanyDto.budget());
    companyRepository.save(companyFound);
    return ResponseEntity.ok("company updated successfully");
  }

  @Override
  public HttpEntity<?> deleteCompany(Long id) {
    companyRepository.clearCompanies(id);
    return ResponseEntity.ok("company deleted successfully");
  }
}
