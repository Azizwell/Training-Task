package org.example.user_service.dto;

public record UpdateUserDto(
        Long id,
        String firstName,
        String lastName,
        String phone

) {
}
