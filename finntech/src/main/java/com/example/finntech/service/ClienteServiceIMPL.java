package com.example.finntech.service;

import com.example.finntech.DTO.ClienteRecordDTO;
import com.example.finntech.entity.Cliente;
import com.example.finntech.entity.Conta;
import com.example.finntech.repository.ClienteRepository;
import com.example.finntech.repository.ContaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceIMPL {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente buscarPorId(UUID id) {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            return cliente.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente cadastrar(ClienteRecordDTO clienteRecordDTO) {
        try {
            Cliente cliente = new Cliente();
            BeanUtils.copyProperties(clienteRecordDTO, cliente);
            clienteRepository.save(cliente);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cliente alterar(ClienteRecordDTO clienteRecordDTO, UUID id) {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if(cliente.isEmpty())
                return null;

            BeanUtils.copyProperties(clienteRecordDTO, cliente.get());
            clienteRepository.save(cliente.get());
            return cliente.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean excluir(UUID id) {
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
