package org.example.company_service.client;


import org.example.company_service.projection.CompanyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
//тут отправка запрос на company-service такой же ест у user-service, они для того чтобы получит все список users и company
@FeignClient(name = "company-service")
public interface CompanyClient {
  @GetMapping("/companies/all_company")
  List<CompanyResponse> getAllCompanies();

}
