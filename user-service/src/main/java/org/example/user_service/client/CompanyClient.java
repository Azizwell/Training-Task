package org.example.user_service.client;


import org.example.user_service.projection.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//тут отправка запрос на company-service такой же ест у user-service, они для того чтобы получит все список users и company
@FeignClient(name = "company-service")
public interface CompanyClient {
  @GetMapping("/companies/company_by_id/{id}")
  CompanyResponse getCompaniesById(@PathVariable Long id);

}
