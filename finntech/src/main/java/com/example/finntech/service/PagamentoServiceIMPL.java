package com.example.finntech.service;

import com.example.finntech.DTO.PagamentoRecordDTO;
import com.example.finntech.entity.Pagamento;
import com.example.finntech.repository.PagamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagamentoServiceIMPL {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<Pagamento> listarTodos() {
        try {
            return pagamentoRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pagamento buscarPorId(UUID id) {
        try {
            Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
            return pagamento.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pagamento cadastrar(PagamentoRecordDTO pagamentoRecordDTO) {
        try {
            Pagamento pagamento = new Pagamento();
            BeanUtils.copyProperties(pagamentoRecordDTO, pagamento);
            pagamentoRepository.save(pagamento);
            return pagamento;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Pagamento alterar(PagamentoRecordDTO pagamentoRecordDTO, UUID id) {
        try {
            Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
            if(pagamento.isEmpty())
                return null;

            BeanUtils.copyProperties(pagamentoRecordDTO, pagamento);
            pagamentoRepository.save(pagamento.get());
            return pagamento.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean excluir(UUID id) {
        try {
            pagamentoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
