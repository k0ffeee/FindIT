package com.example.findit.models;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.findit.controllers.DestinoController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    
    @NotBlank @Size(min = 5, max = 255)
    private String descricaoPT;

    @NotBlank @Size(min = 2, max = 5)
    private String siglaPais;

    public EntityModel<Destino> toEntityModel() {
        return EntityModel.of(
            this,
            linkTo(methodOn(DestinoController.class).show(id)).withSelfRel(),
            linkTo(methodOn(DestinoController.class).index(null, Pageable.unpaged())).withRel("all"),
            linkTo(methodOn(DestinoController.class).show(id)).withRel("destroy")
        );
    }
}
