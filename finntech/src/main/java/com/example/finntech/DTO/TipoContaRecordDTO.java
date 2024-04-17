package com.example.finntech.DTO;

import jakarta.validation.constraints.NotBlank;

public record TipoContaRecordDTO(@NotBlank String tipo) {
}
