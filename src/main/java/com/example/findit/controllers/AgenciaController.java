package com.example.findit.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
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

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.example.findit.exceptions.RestNotFoundException;
import com.example.findit.models.Agencia;
import com.example.findit.repository.AgenciaRepository;


import jakarta.validation.Valid;



@RestController
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Agencia")
@RequestMapping("/api/agencias")
public class AgenciaController{

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    AgenciaRepository agenciaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    @Operation(
        summary = "Detalhar Agencias.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @ParameterObject @PageableDefault(size = 10) Pageable pageable){
        // Page<Agencia> agencias = (busca == null) ? 
        //     agenciaRepository.findAll(pageable) : 
        //     agenciaRepository.findByNomeContaining(busca, pageable);

        Page<Agencia> agencias = agenciaRepository.findAll(pageable);
            
        return assembler.toModel(agencias.map(Agencia::toEntityModel));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar Agencia.",
        description = "Endpoint que recebe os parametros de registro de agencia e cadastra uma." 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Agencia cadastrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Os campos enviados sao invalidos")
    })
    public ResponseEntity<Agencia> create(@RequestBody @Valid Agencia agencia){
        agenciaRepository.save(agencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(agencia);
    }

    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Agencia.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public EntityModel<Agencia> show(@PathVariable Long id){
        var agencia = agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao achar agencia, não encontrada"));
        return agencia.toEntityModel();
    }

    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Agencia.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = ""),
        @ApiResponse(responseCode = "400", description = "")
    })
    public EntityModel<Agencia> update(@PathVariable Long id, @RequestBody @Valid Agencia agencia){
        agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, agencia não encontrada"));

        agencia.setId(id);
        agenciaRepository.save(agencia);

        return agencia.toEntityModel();
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deletar Agencia.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = ""),
        @ApiResponse(responseCode = "401", description = "")
    })
    public ResponseEntity<Agencia> destroy(@PathVariable Long id){
        var agencia = agenciaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, agencia não encontrada"));
        agenciaRepository.delete(agencia);
        return ResponseEntity.noContent().build();
    }
}