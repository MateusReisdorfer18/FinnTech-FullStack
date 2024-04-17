package com.example.finntech.repository;

import com.example.finntech.entity.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BancoRepository extends JpaRepository<Banco, UUID> {
}
