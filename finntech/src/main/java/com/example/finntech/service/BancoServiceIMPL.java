package com.example.finntech.service;

import com.example.finntech.DTO.BancoRecordDTO;
import com.example.finntech.entity.Banco;
import com.example.finntech.repository.BancoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BancoServiceIMPL {
    @Autowired
    private BancoRepository bancoRepository;

    public List<Banco> listarTodos() {
        try {
            return bancoRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Banco buscarPorId(UUID id) {
        try {
            Optional<Banco> banco = bancoRepository.findById(id);
            return banco.orElse(null);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Banco cadastrar(BancoRecordDTO bancoRecordDTO) {
        try {
            Banco banco = new Banco();
            BeanUtils.copyProperties(bancoRecordDTO, banco);
            bancoRepository.save(banco);
            return banco;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Banco alterar(BancoRecordDTO bancoRecordDTO, UUID id) {
        try {
            Optional<Banco> banco = bancoRepository.findById(id);
            if(banco.isEmpty())
                return null;

            BeanUtils.copyProperties(bancoRecordDTO, banco.get());
            bancoRepository.save(banco.get());
            return banco.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean excluir(UUID id) {
        try {
            bancoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
