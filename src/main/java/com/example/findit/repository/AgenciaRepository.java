package com.example.findit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findit.models.Agencia;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    // Page<Agencia> findByNomeContaining(String busca, Pageable pageable);
}           
