package org.example.company_service.service.company;

import org.example.company_service.dto.DtoForCompany.CompanyDto;
import org.example.company_service.dto.DtoForCompany.UpdateCompanyDto;
import org.springframework.http.ResponseEntity;


public interface CompanyService {

  ResponseEntity<CompanyDto> getCompanyById(Long id);

  ResponseEntity<CompanyDto> postCompany(CompanyDto companyDto);

  ResponseEntity<CompanyDto> putCompany(UpdateCompanyDto updateCompanyDto);

  ResponseEntity<String> deleteCompany(Long id);
}
