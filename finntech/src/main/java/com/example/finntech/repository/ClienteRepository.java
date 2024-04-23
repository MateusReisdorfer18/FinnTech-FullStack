package com.example.finntech.repository;

import com.example.finntech.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    @Modifying
    @Transactional
    @Query("INSERT INTO Cliente c (c.nome, c.email, c.senha, c.cpf) VALUES(:nome, :email, MD5(:senha), :cpf)")
    public void cadastro(@Param("nome") String nome, @Param("email") String email, @Param("senha") String senha, @Param("cpf") String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.email=:email AND c.senha=MD5(:senha)")
    public Optional<Cliente> autenticar(@Param("email") String email, @Param("senha") String senha);
}
