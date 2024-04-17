package com.example.finntech.controller;

import com.example.finntech.DTO.TipoContaRecordDTO;
import com.example.finntech.service.TipoContaService;
import com.example.finntech.entity.TipoConta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/finntech/tiposconta")
public class TipoContaController {
    @Autowired
    private TipoContaService tipoContaServiceIMPL;

    @GetMapping("/")
    public ResponseEntity<List<TipoConta>> listarTodos() {
        try {
            return new ResponseEntity<>(tipoContaServiceIMPL.listarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoConta> buscarPorId(@PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(tipoContaServiceIMPL.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<TipoConta> cadastrar(@RequestBody @Valid TipoContaRecordDTO tipoContaRecordDTO) {
        try {
            return new ResponseEntity<>(tipoContaServiceIMPL.cadastrar(tipoContaRecordDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<TipoConta> alterar(@RequestBody @Valid TipoContaRecordDTO tipoContaRecordDTO, @PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(tipoContaServiceIMPL.alterar(tipoContaRecordDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(tipoContaServiceIMPL.excluir(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
