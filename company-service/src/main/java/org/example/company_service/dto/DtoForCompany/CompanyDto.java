package org.example.company_service.dto.DtoForCompany;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CompanyDto(
        Long id,
        @NotBlank
        String name,
        @NotNull
        Double budget,
        List<Long> userIds
) {
}
