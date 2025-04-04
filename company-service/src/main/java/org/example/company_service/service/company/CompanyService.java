package org.example.company_service.service.company;

import org.example.company_service.dto.CompanyDto;
import org.example.company_service.dto.UpdateCompanyDto;
import org.springframework.http.HttpEntity;


public interface CompanyService {

  HttpEntity<?> getAllCompany();

  HttpEntity<?> postCompany(CompanyDto companyDto);

  HttpEntity<?> putCompany(UpdateCompanyDto updateCompanyDto);

  HttpEntity<?> deleteCompany(Long id);
}
