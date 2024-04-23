package com.example.finntech.service;

import com.example.finntech.DTO.ClienteAlterarRecordDTO;
import com.example.finntech.DTO.ClienteCadastroRecordDTO;
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

    @Autowired
    private ContaRepository contaRepository;

    public Cliente autenticar(String email, String senha) {
        try {
            Optional<Cliente> cliente = clienteRepository.autenticar(email, senha);
            return cliente.orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cliente> listarTodos() {
        try {
            return clienteRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Conta> buscarContasPorCliente(UUID id) {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if(cliente.isEmpty())
                return null;

            return contaRepository.findAllConta(cliente.get());
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

    public Boolean cadastrar(ClienteCadastroRecordDTO clienteRecordDTO) {
        try {
            Cliente cliente = new Cliente();
            BeanUtils.copyProperties(clienteRecordDTO, cliente);
            clienteRepository.cadastro(cliente.getNome(), cliente.getEmail(), cliente.getSenha(), cliente.getCpf());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cliente alterar(ClienteAlterarRecordDTO clienteRecordDTO, UUID id) {
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
