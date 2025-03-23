package com.Resvas2025.Reserva.Sevice;

import com.Resvas2025.Reserva.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    // Obtener todos los usuarios
    List<Usuario> obtenerTodos();

    // Obtener un usuario por su ID
    Usuario obtenerPorId(Integer id);

    // Guardar un nuevo usuario
    Usuario guardar(Usuario usuario);

    // Obtener el perfil de un usuario por su ID
    Usuario obtenerPerfil(Integer id);

    // Actualizar el perfil de un usuario
    Usuario actualizarPerfil(Integer id, Usuario datosActualizados);
    Optional<Usuario> findByCorreo(String correo); 
}
