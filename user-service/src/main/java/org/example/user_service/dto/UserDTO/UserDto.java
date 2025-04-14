package org.example.user_service.dto.UserDTO;

import jakarta.validation.constraints.NotBlank;

public record UserDto(
        Long id,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String phone,
        Long companyId

) {
}
