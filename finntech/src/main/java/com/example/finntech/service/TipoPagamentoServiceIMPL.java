package com.example.finntech.service;

import com.example.finntech.DTO.TipoPagamentoRecordDTO;
import com.example.finntech.entity.TipoPagamento;
import com.example.finntech.repository.TipoPagamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TipoPagamentoServiceIMPL {
    @Autowired
    private TipoPagamentoRepository tipoPagamentoRepository;

    public List<TipoPagamento> listarTodos() {
        try {
            return tipoPagamentoRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoPagamento buscarPorId(UUID id) {
        try {
            Optional<TipoPagamento> tipoPagamento = tipoPagamentoRepository.findById(id);
            return tipoPagamento.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoPagamento cadastrar(TipoPagamentoRecordDTO tipoPagamentoRecordDTO) {
        try {
            TipoPagamento tipoPagamento = new TipoPagamento();
            BeanUtils.copyProperties(tipoPagamentoRecordDTO, tipoPagamento);
            tipoPagamentoRepository.save(tipoPagamento);
            return tipoPagamento;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public TipoPagamento alterar(TipoPagamentoRecordDTO tipoPagamentoRecordDTO, UUID id){
        try {
            Optional<TipoPagamento> tipoPagamento = tipoPagamentoRepository.findById(id);
            if(tipoPagamento.isEmpty())
                return null;

            BeanUtils.copyProperties(tipoPagamentoRecordDTO, tipoPagamento);
            tipoPagamentoRepository.save(tipoPagamento.get());
            return tipoPagamento.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean excluir(UUID id) {
        try {
            tipoPagamentoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
