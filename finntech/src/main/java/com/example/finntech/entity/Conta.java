package com.example.finntech.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "conta")
@Getter @Setter @NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private Integer numero = new Random().nextInt();

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private TipoConta tipoConta;
    private Double saldo = 0.0;
    private Double limite = 0.0;

    @OneToOne
    private Banco banco;

    @OneToMany
    private List<Pagamento> extrato = new ArrayList<>();
}
