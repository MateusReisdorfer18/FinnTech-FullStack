package com.example.finntech.service;

import com.example.finntech.DTO.ContaRecordDTO;
import com.example.finntech.entity.Conta;
import com.example.finntech.repository.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContaServiceIMPL {
    @Autowired
    private ContaRepository contaRepository;

    public List<Conta> listarTodos() {
        try {
            return contaRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Conta buscarPorId(UUID id) {
        try {
            Optional<Conta> conta = contaRepository.findById(id);
            return conta.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Conta cadastrar(ContaRecordDTO contaRecordDTO) {
        try {
            Conta conta = new Conta();
            BeanUtils.copyProperties(contaRecordDTO, conta);
            contaRepository.save(conta);
            return conta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Conta alterar(ContaRecordDTO contaRecordDTO, UUID id) {
        try {
            Optional<Conta> conta = contaRepository.findById(id);
            if(conta.isEmpty())
                return null;

            BeanUtils.copyProperties(contaRecordDTO, conta.get());
            contaRepository.save(conta.get());
            return conta.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean excluir(UUID id) {
        try {
            contaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}