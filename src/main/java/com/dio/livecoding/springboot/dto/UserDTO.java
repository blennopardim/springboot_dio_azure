package com.dio.livecoding.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotEmpty(message = "The name field is required")
    private String name;
    @NotEmpty(message = "The email field is required")
    private String email;
}
