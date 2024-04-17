package com.example.finntech.DTO;

import jakarta.validation.constraints.NotBlank;

public record BancoRecordDTO (@NotBlank String nome){
}
