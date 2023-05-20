package com.example.findit.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.findit.exceptions.RestNotFoundException;
import com.example.findit.models.Agencia;
import com.example.findit.repository.AgenciaRepository;


import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/agencias")
public class AgenciaController{

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AgenciaRepository agenciaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 10) Pageable pageable){
        // Page<Agencia> agencias = (busca == null) ? 
        //     agenciaRepository.findAll(pageable) : 
        //     agenciaRepository.findByAgenciaContaining(busca, pageable);

        Page<Agencia> agencias = agenciaRepository.findAll(pageable);
            
        return assembler.toModel(agencias.map(Agencia::toEntityModel));
    }

    @PostMapping
    public ResponseEntity<Agencia> create(@RequestBody @Valid Agencia agencia){
        agenciaRepository.save(agencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(agencia);
    }

    @GetMapping("{id}")
    public EntityModel<Agencia> show(@PathVariable Long id){
        var agencia = agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, despesa não encontrada"));
        return agencia.toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Agencia> update(@PathVariable Long id, @RequestBody @Valid Agencia agencia){
        agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, despesa não encontrada"));

        agencia.setId(id);
        agenciaRepository.save(agencia);

        return agencia.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Agencia> destroy(@PathVariable Long id){
        var agencia = agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, agencia não encontrada"));
        agenciaRepository.delete(agencia);
        return ResponseEntity.noContent().build();
    }
}