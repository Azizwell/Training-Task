package org.example.company_service.repository;


import org.example.company_service.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Long> {


}
