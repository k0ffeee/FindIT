package com.example.findit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findit.models.Preferencias;

public interface PreferenciasRepository extends JpaRepository<Preferencias, Long> {
    // Page<Preferencias> findByNomeContaining(String busca, Pageable pageable);
}
