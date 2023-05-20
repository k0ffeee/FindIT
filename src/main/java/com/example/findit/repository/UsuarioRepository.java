package com.example.findit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.findit.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
}
