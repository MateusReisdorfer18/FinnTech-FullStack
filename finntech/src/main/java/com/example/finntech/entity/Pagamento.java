package com.example.finntech.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pagamento")
@Getter @Setter @NoArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @OneToOne
    private TipoPagamento tipoPagamento;

    @OneToOne
    private Conta rementente;

    @OneToOne
    private Conta destinatario;
    private Double valor;

    private LocalDateTime dataCriacao = LocalDateTime.now();
}
