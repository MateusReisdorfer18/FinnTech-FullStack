package com.example.finntech.DTO;

import jakarta.validation.constraints.NotBlank;

public record ClienteRecordDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String cpf) {
}
