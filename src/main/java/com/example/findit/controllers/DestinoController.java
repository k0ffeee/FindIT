package com.example.findit.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.findit.models.Destino;
import com.example.findit.repository.DestinoRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Destino")
@RequestMapping("/api/destinos")
public class DestinoController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    DestinoRepository destinoRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping
    @Operation(
        summary = "Detalhar Destinos.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 10) Pageable pageable){
        Page<Destino> destino = destinoRepository.findAll(pageable);

        return assembler.toModel(destino.map(Destino::toEntityModel));
    }

    @PostMapping
    @Operation(
        summary = "Cadastrar Destino.",
        description = "Endpoint que recebe os parametros de registro de Destino e cadastra uma." 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Destino cadastrada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Os campos enviados sao invalidos")
    })
    public ResponseEntity<Destino> create(@RequestBody @Valid Destino destino){
        destinoRepository.save(destino);
        return ResponseEntity.status(HttpStatus.CREATED).body(destino);
    }

    
    @GetMapping("{id}")
    @Operation(
        summary = "Detalhar Destino.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = ""),
        @ApiResponse(responseCode = "404", description = "")
    })
    public EntityModel<Destino> show(@PathVariable Long id){
        var destino = destinoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao achar caracteristica, não encontrada"));
        return destino.toEntityModel();
    }


    @PutMapping("{id}")
    @Operation(
        summary = "Atualizar Destino.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = ""),
        @ApiResponse(responseCode = "400", description = "")
    })
    public EntityModel<Destino> update(@PathVariable Long id, @RequestBody @Valid Destino destino){
        destinoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, Destino não encontrada"));

        destino.setId(id);
        destinoRepository.save(destino);

        return destino.toEntityModel();
    }

    @DeleteMapping("{id}")
    @Operation(
        summary = "Deletar Destino.",
        description = "" 
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = ""),
        @ApiResponse(responseCode = "401", description = "")
    })
    public ResponseEntity<Destino> destroy(@PathVariable Long id){
        var destino = destinoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, Destino não encontrada"));
        destinoRepository.delete(destino);
        return ResponseEntity.noContent().build();
    }
}
