package com.ib.lms.auth.dto;

import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Login Request DTO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "User ID is required")
    @Size(min = 3, max = 20, message = "User ID must be between 3 and 20 characters")
    private String userid;

    @NotBlank(message = "Password is required")
    private String password;
}