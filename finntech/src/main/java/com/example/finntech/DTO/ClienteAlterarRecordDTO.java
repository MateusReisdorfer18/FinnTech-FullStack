package com.example.finntech.DTO;

import jakarta.validation.constraints.NotBlank;

public record ClienteAlterarRecordDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String cpf) {
}
