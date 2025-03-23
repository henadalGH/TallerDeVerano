package com.Resvas2025.Reserva.repositorio;

import org.springframework.stereotype.Repository;

import com.Resvas2025.Reserva.model.Usuario;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Método para buscar un usuario por correo electrónico
    Optional<Usuario> findByCorreo(String correo);
    // Método para buscar un usuario por nombre de usuario
    Optional<Usuario> findByNombre(String nombre);

}
