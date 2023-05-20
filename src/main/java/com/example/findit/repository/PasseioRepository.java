package com.example.findit.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findit.models.Passeio;

public interface PasseioRepository extends JpaRepository<Passeio, Long>{
    // Page<Passeio> findByNomeContaining(String busca, Pageable pageable);
}
