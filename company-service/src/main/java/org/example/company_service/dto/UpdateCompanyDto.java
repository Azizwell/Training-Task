package org.example.company_service.dto;

public record UpdateCompanyDto(
        Long id,
        String name,
        Double budget
) {
}
