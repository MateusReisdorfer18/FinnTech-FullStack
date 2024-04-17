package com.example.finntech.DTO;

import com.example.finntech.entity.Banco;
import com.example.finntech.entity.Cliente;
import com.example.finntech.entity.TipoConta;
import jakarta.validation.constraints.NotNull;

public record ContaRecordDTO(@NotNull Cliente cliente, @NotNull TipoConta tipoConta, @NotNull Banco banco) {
}
