package com.example.findit.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findit.models.Caracteristicas;

public interface CaracteristicaRepository extends JpaRepository<Caracteristicas, Long> {
    // Page<Caracteristicas> findByNomeContaining(String busca, Pageable pageable);
}           
