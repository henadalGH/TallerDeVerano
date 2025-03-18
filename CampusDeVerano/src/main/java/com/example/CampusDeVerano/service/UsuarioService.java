package com.example.CampusDeVerano.service;

import com.example.CampusDeVerano.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UsuarioService {
    public List<Usuario> obtenerTodos();
    public Usuario obtenerPorId(Integer id);
    public Usuario guardar(Usuario usuario);
    public void eliminar(Integer id);
    public Usuario obtenerPerfil(Integer id);
    public Usuario actualizarPerfil(Integer id, Usuario datosActualizados);
}

