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
import com.example.findit.models.Preferencias;
import com.example.findit.repository.PreferenciasRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/preferencias")
public class PreferenciasController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PreferenciasRepository preferenciasRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 10) Pageable pageable){
        Page<Preferencias> preferencias = preferenciasRepository.findAll(pageable);

        return assembler.toModel(preferencias.map(Preferencias::toEntityModel));
    }

    @PostMapping
    public ResponseEntity<Preferencias> create(@RequestBody @Valid Preferencias preferencias){
        preferenciasRepository.save(preferencias);
        return ResponseEntity.status(HttpStatus.CREATED).body(preferencias);
    }

    @GetMapping("{id}")
    public EntityModel<Preferencias> show(@PathVariable Long id){
        var preferencias = preferenciasRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao achar preferencia, não encontrada"));
        return preferencias.toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Preferencias> update(@PathVariable Long id, @RequestBody @Valid Preferencias preferencias){
        preferenciasRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, preferencia não encontrada"));

        preferencias.setId(id);
        preferenciasRepository.save(preferencias);

        return preferencias.toEntityModel();
    }   

    @DeleteMapping("{id}")
    public ResponseEntity<Preferencias> destroy(@PathVariable Long id){
        var preferencias = preferenciasRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, preferencia não encontrada"));
        preferenciasRepository.delete(preferencias);
        return ResponseEntity.noContent().build();
    }

}
