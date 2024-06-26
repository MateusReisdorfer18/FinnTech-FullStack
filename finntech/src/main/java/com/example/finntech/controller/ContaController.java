package com.example.finntech.controller;

import com.example.finntech.DTO.ContaRecordDTO;
import com.example.finntech.DTO.TransacaoRecordDTO;
import com.example.finntech.entity.Pagamento;
import com.example.finntech.service.ContaServiceIMPL;
import com.example.finntech.entity.Conta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("finntech/contas")
public class ContaController {
    @Autowired
    private ContaServiceIMPL contaServiceIMPL;

    @GetMapping("/")
    public ResponseEntity<List<Conta>> listarTodos() {
        try {
            return new ResponseEntity<>(contaServiceIMPL.listarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/numero/{numero}")
    public ResponseEntity<Conta> buscarPorNumero(@PathVariable("numero") Integer numero) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.buscarPorNumero(numero), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/acoes/listarpagamentos/{id}")
    public ResponseEntity<List<Pagamento>> listarPagamento(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.listarPagamentos(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Conta> cadastrar(@RequestBody @Valid ContaRecordDTO contaRecordDTO) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.cadastrar(contaRecordDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Conta> alterar(@RequestBody @Valid ContaRecordDTO contaRecordDTO, @PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.alterar(contaRecordDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/acoes/deposito/{id}")
    public ResponseEntity<Boolean> depositar(@RequestBody @Valid TransacaoRecordDTO transacaoRecordDTO, @PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.depositar(transacaoRecordDTO.valor(), id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/acoes/sacar/id/{id}")
    public ResponseEntity<Boolean> sacar(@RequestBody @Valid TransacaoRecordDTO transacaoRecordDTO, @PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.sacar(transacaoRecordDTO.valor(), id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(contaServiceIMPL.excluir(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
