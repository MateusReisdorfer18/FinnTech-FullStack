package com.example.finntech.DTO;

import jakarta.validation.constraints.NotBlank;

public record ClienteAutorizarRecordDTO(@NotBlank String email, @NotBlank String senha) {
}
