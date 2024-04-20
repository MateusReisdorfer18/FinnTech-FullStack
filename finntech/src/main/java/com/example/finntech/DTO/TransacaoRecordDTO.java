package com.example.finntech.DTO;

import jakarta.validation.constraints.NotNull;

public record TransacaoRecordDTO(@NotNull Double valor) {
}
