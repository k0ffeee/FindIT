package com.example.findit.models;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.example.findit.controllers.CaracteristicasController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Caracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String tipo;

    @ManyToOne
    private Destino destino;

    public EntityModel<Caracteristicas> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(CaracteristicasController.class).show(id)).withSelfRel(),
            linkTo(methodOn(CaracteristicasController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(CaracteristicasController.class).show(id)).withRel("destroy")
        );
    }
}
