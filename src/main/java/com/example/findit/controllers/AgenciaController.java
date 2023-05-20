package com.example.findit.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.findit.models.Agencia;
import com.example.findit.repository.AgenciaRepository;


import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/agencias")
public class AgenciaController{

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AgenciaRepository agenciaRepository;

    @GetMapping
    public List<Agencia> index(){
        return agenciaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Agencia> create(@RequestBody @Valid Agencia conta){
        log.info("cadastrando conta " + conta);
        agenciaRepository.save(conta);
        return ResponseEntity.status(HttpStatus.CREATED).body(conta);
    }

    @GetMapping("{id}")
    public ResponseEntity<Agencia> show(@PathVariable Long id){
        log.info("detalhando conta " + id);
        return ResponseEntity.ok(getAgencia(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Agencia> destroy(@PathVariable Long id){
        log.info("apagando despesa " + id);
        var despesa = agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, despesa não encontrada"));

            agenciaRepository.delete(despesa);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public EntityModel<Agencia> update(@PathVariable Long id, @RequestBody @Valid Agencia despesa){
        log.info("atualizando despesa " + id);
        agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, despesa não encontrada"));

        despesa.setId(id);
        agenciaRepository.save(despesa);

        return despesa.toEntityModel();
    }


    private Agencia getConta(Long id) {
        return agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("conta não encontrada")); 
    }
}