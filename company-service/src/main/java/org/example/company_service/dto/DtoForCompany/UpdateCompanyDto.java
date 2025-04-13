package org.example.company_service.dto.DtoForCompany;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UpdateCompanyDto(
        @NotNull
        @NotEmpty
        Long id,
        @NotBlank
        String name,
        @NotNull
        @NotEmpty
        Double budget,
        List<Long> userIds
) {
}
