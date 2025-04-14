package org.example.user_service.dto;

public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String phone,
        CompanyResponseDto company
) {

}
