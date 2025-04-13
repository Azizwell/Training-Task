package org.example.company_service.service.company;

import org.example.company_service.dto.DtoForCompany.CompanyDto;
import org.example.company_service.dto.DtoForCompany.UpdateCompanyDto;
import org.example.company_service.entity.Company;
import org.example.company_service.mapper.CompanyMapper;
import org.example.company_service.repository.CompanyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CompanyServiceImpl implements CompanyService {
  @Autowired
  private CompanyRepository companyRepository;

  private final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

  @Override
  public ResponseEntity<CompanyDto> getCompanyById(Long id) {
    Company findCompany = companyRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company не найдено")
    );
    CompanyDto companyDto = CompanyMapper.toDto(findCompany);
    log.info("Возврашено найденный Company: {}", findCompany);
    return ResponseEntity.ok(companyDto);
  }


  @Override
  public ResponseEntity<CompanyDto> postCompany(CompanyDto companyDto) {
    Company entity = CompanyMapper.toEntity(companyDto);
    CompanyDto CompanyDto = CompanyMapper.toDto(companyRepository.save(entity));

    log.info("Создань  company: {}", CompanyDto);
    return ResponseEntity.ok(CompanyDto);
  }

  @Override
  public ResponseEntity<CompanyDto> putCompany(UpdateCompanyDto updateCompanyDto) {
    Company companyFound = companyRepository.findById(updateCompanyDto.id()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company не найдено")
    );
    companyFound.setName(updateCompanyDto.name());
    companyFound.setBudget(updateCompanyDto.budget());

    CompanyDto companyDto = CompanyMapper.toDto(companyRepository.save(companyFound));
    log.info("Изменен выбранный company: {}", companyDto);
    return ResponseEntity.ok(companyDto);
  }

  @Override
  public ResponseEntity<String> deleteCompany(Long id) {
    companyRepository.deleteById(id);
    log.info("Удалено выбранный company по ид: {}", id);
    return ResponseEntity.ok("company deleted successfully");
  }
}
