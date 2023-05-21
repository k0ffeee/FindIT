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
import com.example.findit.models.Viagem;
import com.example.findit.repository.ViagemRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/viagens")
public class ViagemController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ViagemRepository viagemRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 10) Pageable pageable){
        Page<Viagem> viagem = viagemRepository.findAll(pageable);

        return assembler.toModel(viagem.map(Viagem::toEntityModel));
    }

    @PostMapping
    public ResponseEntity<Viagem> create(@RequestBody @Valid Viagem viagem){
        viagemRepository.save(viagem);
        return ResponseEntity.status(HttpStatus.CREATED).body(viagem);
    }

    @GetMapping("{id}")
    public EntityModel<Viagem> show(@PathVariable Long id){
        var viagem = viagemRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao achar viagem, não encontrada"));
        return viagem.toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Viagem> update(@PathVariable Long id, @RequestBody @Valid Viagem viagem){
        viagemRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, viagem não encontrada"));

        viagem.setId(id);
        viagemRepository.save(viagem);

        return viagem.toEntityModel();
    } 

    @DeleteMapping("{id}")
    public ResponseEntity<Viagem> destroy(@PathVariable Long id){
        var viagem = viagemRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, viagem não encontrada"));
        viagemRepository.delete(viagem);
        return ResponseEntity.noContent().build();
    }

}
