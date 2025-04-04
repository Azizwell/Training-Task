package org.example.company_service.dto;

public record UpdateUserDto(
        Long id,
        String firstName,
        String lastName,
        String phone

) {
}
