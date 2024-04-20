package com.example.finntech.repository;

import com.example.finntech.entity.Cliente;
import com.example.finntech.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

}
