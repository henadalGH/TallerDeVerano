package com.Reseva.Taller.Reservas.Sevice;

import org.springframework.stereotype.Service;

import com.Reseva.Taller.Reservas.model.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {
    public List<Usuario> obtenerTodos();
    public Usuario obtenerPorId(Integer id);
    public Usuario guardar(Usuario usuario);
    public void eliminar(Integer id);
    public Usuario obtenerPerfil(Integer id);
    public Usuario actualizarPerfil(Integer id, Usuario datosActualizados);
    Optional<Usuario> findByCorreo(String correo);
    
    
}

