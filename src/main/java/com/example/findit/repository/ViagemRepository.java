package com.example.findit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findit.models.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long>{
    // Page<Viagem>findByNomeContaining(String busca, Pageable pageable);
}
