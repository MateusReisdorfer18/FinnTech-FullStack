package com.example.finntech.controller;

import com.example.finntech.DTO.ClienteAutorizarRecordDTO;
import com.example.finntech.DTO.ClienteCadastroRecordDTO;
import com.example.finntech.DTO.ClienteAlterarRecordDTO;
import com.example.finntech.entity.Conta;
import com.example.finntech.service.ClienteServiceIMPL;
import com.example.finntech.entity.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/finntech/clientes")
public class ClienteController {
    @Autowired
    private ClienteServiceIMPL clienteServiceIMPL;

    @GetMapping("/entrar/contas/autorizar")
    public ResponseEntity<Cliente> autorizar(@RequestBody @Valid ClienteAutorizarRecordDTO clienteRecordDTO) {
        try {
            Cliente clienteEncontrado = clienteServiceIMPL.autenticar(clienteRecordDTO.email(), clienteRecordDTO.senha());
            if(clienteEncontrado == null)
                    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);


            return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> listarTodos() {
        try {
            return new ResponseEntity<>(clienteServiceIMPL.listarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(clienteServiceIMPL.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listarcontas/{id}")
    public ResponseEntity<List<Conta>> buscarContasPorCliente(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(clienteServiceIMPL.buscarContasPorCliente(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Boolean> cadastrar(@RequestBody @Valid ClienteCadastroRecordDTO clienteRecordDTO){
        try {
            return new ResponseEntity<>(clienteServiceIMPL.cadastrar(clienteRecordDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Cliente> alterar(@RequestBody @Valid ClienteAlterarRecordDTO clienteRecordDTO, @PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(clienteServiceIMPL.alterar(clienteRecordDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(clienteServiceIMPL.excluir(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
