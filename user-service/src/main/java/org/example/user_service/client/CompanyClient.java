package org.example.user_service.client;


import org.example.user_service.dto.feignDto.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "company-service")
public interface CompanyClient {
  @GetMapping("/companies/company_by_id/{id}")
  CompanyResponse getCompaniesById(@PathVariable Long id);

}
