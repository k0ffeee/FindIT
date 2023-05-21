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
import com.example.findit.models.Passeio;
import com.example.findit.repository.PasseioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/passeios")
public class PasseioController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PasseioRepository passeioRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;


    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 10) Pageable pageable){
        Page<Passeio> passeio = passeioRepository.findAll(pageable);

        return assembler.toModel(passeio.map(Passeio::toEntityModel));
    }

    @PostMapping
    public ResponseEntity<Passeio> create(@RequestBody @Valid Passeio passeio){
        passeioRepository.save(passeio);
        return ResponseEntity.status(HttpStatus.CREATED).body(passeio);
    }

    @GetMapping("{id}")
    public EntityModel<Passeio> show(@PathVariable Long id){
        var passeio = passeioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao achar passeio, não encontrada"));
        return passeio.toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Passeio> update(@PathVariable Long id, @RequestBody @Valid Passeio passeio){
        passeioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, passeio não encontrada"));

        passeio.setId(id);
        passeioRepository.save(passeio);

        return passeio.toEntityModel();
    }    

    @DeleteMapping("{id}")
    public ResponseEntity<Passeio> destroy(@PathVariable Long id){
        var passeio = passeioRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, passeio não encontrada"));
        passeioRepository.delete(passeio);
        return ResponseEntity.noContent().build();
    }

}
