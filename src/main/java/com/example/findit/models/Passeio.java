package com.example.findit.models;

import org.springframework.hateoas.EntityModel;

import com.example.findit.controllers.PasseioController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Passeio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @NotBlank @Size(min = 5, max = 255)
    private String descricao;

    @ManyToOne
    private Destino destino;

    public EntityModel<Passeio> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(PasseioController.class).show(id)).withSelfRel(),
            linkTo(methodOn(PasseioController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(PasseioController.class).show(id)).withRel("destroy")
        );
    }

}
