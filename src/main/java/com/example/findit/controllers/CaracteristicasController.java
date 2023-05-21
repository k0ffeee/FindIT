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
import com.example.findit.models.Caracteristicas;
import com.example.findit.repository.AgenciaRepository;
import com.example.findit.repository.CaracteristicaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/caracteristicas")
public class CaracteristicasController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CaracteristicaRepository caracteristicaRepository;

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String busca, @PageableDefault(size = 10) Pageable pageable){
        Page<Caracteristicas> caracteristicas = caracteristicaRepository.findAll(pageable);

        return assembler.toModel(caracteristicas.map(Caracteristicas::toEntityModel));
    }

    @PostMapping
    public ResponseEntity<Caracteristicas> create(@RequestBody @Valid Caracteristicas caracteristicas){
        caracteristicaRepository.save(caracteristicas);
        return ResponseEntity.status(HttpStatus.CREATED).body(caracteristicas);
    }

    @GetMapping("{id}")
    public EntityModel<Caracteristicas> show(@PathVariable Long id){
        var caracteristicas = caracteristicaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao achar caracteristica, não encontrada"));
        return caracteristicas.toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Caracteristicas> update(@PathVariable Long id, @RequestBody @Valid Caracteristicas caracteristicas){
        caracteristicaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, caracteristica não encontrada"));

        caracteristicas.setId(id);
        caracteristicaRepository.save(caracteristicas);

        return caracteristicas.toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Caracteristicas> destroy(@PathVariable Long id){
        var caracteristica = caracteristicaRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Erro ao apagar, caracteristica não encontrada"));
        caracteristicaRepository.delete(caracteristica);
        return ResponseEntity.noContent().build();
    }
}
