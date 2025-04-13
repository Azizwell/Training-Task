package org.example.company_service.controller;


import jakarta.validation.Valid;
import org.example.company_service.dto.DtoForCompany.CompanyDto;
import org.example.company_service.dto.DtoForCompany.UpdateCompanyDto;
import org.example.company_service.projection.CompanyResponseProjection;
import org.example.company_service.service.UserService;
import org.example.company_service.service.company.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
  @Autowired
  private CompanyService companyService;

  @Autowired
  private UserService userService;

  private final Logger log = LoggerFactory.getLogger(CompanyController.class);

  @GetMapping("/company_by_id/{id}")
  public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
    log.info("Получен Get запрос на получение компании с ID: {}", id);
    return companyService.getCompanyById(id);
  }

  @GetMapping("/company-users/{id}")
  public HttpEntity<CompanyResponseProjection> getCompanyWithUser(@PathVariable Long id) {
    log.info("Получен Get запрос на получение компании с ползовательями с ID: {}", id);
    return ResponseEntity.ok(userService.getCompanyById(id));
  }

  @PostMapping
  public ResponseEntity<CompanyDto> postCompany(@Valid @RequestBody CompanyDto companyDto) {
    log.info("Получен запрос создание компании: {}", companyDto);
    return companyService.postCompany(companyDto);
  }

  @PutMapping
  public ResponseEntity<CompanyDto> putCompany(@Valid @RequestBody UpdateCompanyDto updateCompanyDto) {
    log.info("Получен запрос на обновление компании: {}", updateCompanyDto);
    return companyService.putCompany(updateCompanyDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
    log.info("Получен Delete запрос на получение компании с ID: {}", id);
    return companyService.deleteCompany(id);
  }


}
