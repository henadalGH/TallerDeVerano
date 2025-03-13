package com.example.CampusDeVerano.repositorio;

import com.example.CampusDeVerano.model.Usuario;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    
}
