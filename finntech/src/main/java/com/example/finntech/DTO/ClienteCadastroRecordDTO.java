package com.example.finntech.DTO;

import jakarta.validation.constraints.NotBlank;

public record ClienteCadastroRecordDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String senha, @NotBlank String cpf) {
}
