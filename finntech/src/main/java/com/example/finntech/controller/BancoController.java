package com.example.finntech.controller;

import com.example.finntech.DTO.BancoRecordDTO;
import com.example.finntech.service.BancoServiceIMPL;
import com.example.finntech.entity.Banco;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/finntech/bancos")
public class BancoController {
    @Autowired
    private BancoServiceIMPL bancoServiceIMPL;

    @GetMapping("/")
    public ResponseEntity<List<Banco>> listarTodos() {
        try {
            return new ResponseEntity<>(bancoServiceIMPL.listarTodos(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> buscarPorId(@PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(bancoServiceIMPL.buscarPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Banco> cadastrar(@RequestBody @Valid BancoRecordDTO bancoRecordDTO) {
        try {
            return new ResponseEntity<>(bancoServiceIMPL.cadastrar(bancoRecordDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Banco> alterar(@RequestBody @Valid BancoRecordDTO bancoRecordDTO, @PathVariable("id")UUID id) {
        try {
            return new ResponseEntity<>(bancoServiceIMPL.alterar(bancoRecordDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") UUID id) {
        try {
            return new ResponseEntity<>(bancoServiceIMPL.excluir(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
