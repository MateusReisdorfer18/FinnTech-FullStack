package com.example.finntech.DTO;

import com.example.finntech.entity.Conta;
import com.example.finntech.entity.TipoPagamento;
import jakarta.validation.constraints.NotNull;

public record PagamentoRecordDTO(@NotNull TipoPagamento tipoPagamento, @NotNull Conta remetente, @NotNull Conta destinatario, @NotNull Double valor) {
}
