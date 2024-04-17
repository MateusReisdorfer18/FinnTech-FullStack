package com.example.finntech.DTO;

import jakarta.validation.constraints.NotBlank;

public record TipoPagamentoRecordDTO(@NotBlank String tipo) {
}
