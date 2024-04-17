package com.example.finntech.controller;

import com.example.finntech.DTO.TipoPagamentoRecordDTO;
import com.example.finntech.service.TipoPagamentoServiceIMPL;
import com.example.finntech.entity.TipoPagamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("finntech/tipospagamento")
public class TipoPagamentoController {
    @Autowired
    private TipoPagamentoServiceIMPL tipoPagamentoServiceIMPL;

    @GetMapping("/")
    public ResponseEntity<List<TipoPagamento>> listarTodos() {
        try {
            return new ResponseEntity<>(tipoPagamentoServiceIMPL.listarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPagamento> buscarPorId(@PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(tipoPagamentoServiceIMPL.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<TipoPagamento> cadastrar(@RequestBody @Valid TipoPagamentoRecordDTO tipoPagamentoRecordDTO) {
        try {
            return new ResponseEntity<>(tipoPagamentoServiceIMPL.cadastrar(tipoPagamentoRecordDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<TipoPagamento> alterar(@RequestBody @Valid TipoPagamentoRecordDTO tipoPagamentoRecordDTO, @PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(tipoPagamentoServiceIMPL.alterar(tipoPagamentoRecordDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(tipoPagamentoServiceIMPL.excluir(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
