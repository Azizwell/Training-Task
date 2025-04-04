package org.example.company_service.controller;


import org.example.company_service.dto.CompanyDto;
import org.example.company_service.dto.UpdateCompanyDto;
import org.example.company_service.service.company.CompanyService;
import org.example.company_service.service.UserService;
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


  @GetMapping("/all_company")
  public HttpEntity<?> getAllCompany() {
    return companyService.getAllCompany();
  }

  @GetMapping("/company-users")
  public HttpEntity<?> getCompanyWithUser() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PostMapping
  public HttpEntity<?> postCompany(@RequestBody CompanyDto companyDto) {
    return companyService.postCompany(companyDto);
  }

  @PutMapping
  public HttpEntity<?> putCompany(@RequestBody UpdateCompanyDto updateCompanyDto) {
    return companyService.putCompany(updateCompanyDto);
  }

  @DeleteMapping("/{id}")
  public HttpEntity<?> deleteCompany(@PathVariable Long id) {
   return companyService.deleteCompany(id);
  }


}
