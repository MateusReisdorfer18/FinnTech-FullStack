package com.example.finntech.service;

import com.example.finntech.DTO.TipoContaRecordDTO;
import com.example.finntech.entity.TipoConta;
import com.example.finntech.repository.TipoContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class TipoContaService {
    @Autowired
    private TipoContaRepository tipoContaRepository;

    public List<TipoConta> listarTodos() {
        try {
            return tipoContaRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoConta buscarPorId(UUID id) {
        try {
            Optional<TipoConta> tipoConta = tipoContaRepository.findById(id);
            return tipoConta.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoConta cadastrar(TipoContaRecordDTO tipoContaRecordDTO) {
        try {
            TipoConta tipoConta = new TipoConta();
            BeanUtils.copyProperties(tipoContaRecordDTO, tipoConta);
            tipoContaRepository.save(tipoConta);
            return tipoConta;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoConta alterar(TipoContaRecordDTO tipoContaRecordDTO, UUID id) {
        try {
            Optional<TipoConta> tipoConta = tipoContaRepository.findById(id);
            if(tipoConta.isEmpty())
                return null;

            BeanUtils.copyProperties(tipoContaRecordDTO, tipoConta);
            tipoContaRepository.save(tipoConta.get());
            return tipoConta.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean excluir(UUID id) {
        try {
            tipoContaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
