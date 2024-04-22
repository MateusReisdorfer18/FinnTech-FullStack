package com.example.finntech.repository;

import com.example.finntech.entity.Cliente;
import com.example.finntech.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ContaRepository extends JpaRepository<Conta, UUID> {
    @Query("SELECT c FROM Conta c WHERE c.numero = :numero")
    Optional<Conta> findByNumero(Integer numero);

    @Query("SELECT c FROM Conta c WHERE c.cliente = :cliente")
    List<Conta> findAllConta(@Param("cliente") Cliente cliente);

    @Modifying
    @Transactional
    @Query("UPDATE Conta c SET c.saldo = :valor WHERE c.id = :id")
    void updateSaldo(@Param("valor") Double valor, @Param("id") UUID id);
}
