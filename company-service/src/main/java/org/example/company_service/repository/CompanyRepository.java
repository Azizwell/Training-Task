package org.example.company_service.repository;


import org.example.company_service.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface CompanyRepository extends JpaRepository<Company, Long> {
  @Transactional
  @Modifying
  @Query(value = " DELETE FROM company_user_id WHERE company_id = :id;\n" +
          "          DELETE FROM company WHERE id = :id AND NOT EXISTS \n" +
          "              (SELECT * FROM company_user_id WHERE company_id = :id);"
          , nativeQuery = true)
  void clearCompanies(Long id);

}
