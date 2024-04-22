package com.example.finntech.repository;

import com.example.finntech.entity.Conta;
import com.example.finntech.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {
    @Query("SELECT p FROM Pagamento p WHERE remetente = :conta OR destinatario = :conta")
    List<Pagamento> findByRemetenteOrDestinatario(@Param("conta")Conta conta);
}
