package com.example.finntech.controller;

import com.example.finntech.DTO.PagamentoRecordDTO;
import com.example.finntech.service.PagamentoServiceIMPL;
import com.example.finntech.entity.Pagamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/finntech/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoServiceIMPL pagamentoServiceIMPL;

    @GetMapping("/")
    public ResponseEntity<List<Pagamento>> listarTodos() {
        try {
            return new ResponseEntity<>(pagamentoServiceIMPL.listarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPorId(@PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(pagamentoServiceIMPL.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Pagamento> cadastrar(@RequestBody @Valid PagamentoRecordDTO pagamentoRecordDTO) {
        try {
            return new ResponseEntity<>(pagamentoServiceIMPL.cadastrar(pagamentoRecordDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Pagamento> alterar(@RequestBody @Valid PagamentoRecordDTO pagamentoRecordDTO, @PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(pagamentoServiceIMPL.alterar(pagamentoRecordDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(pagamentoServiceIMPL.excluir(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
