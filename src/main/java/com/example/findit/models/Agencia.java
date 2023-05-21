package com.example.findit.models;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;

import com.example.findit.controllers.AgenciaController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sigla;

    public EntityModel<Agencia> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(AgenciaController.class).show(id)).withSelfRel(),
            linkTo(methodOn(AgenciaController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(AgenciaController.class).show(id)).withRel("destroy")
        );
    }
}
