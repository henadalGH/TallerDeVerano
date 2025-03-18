package com.example.CampusDeVerano.service.impl;

import com.example.CampusDeVerano.model.Usuario;
import com.example.CampusDeVerano.repositorio.UsuarioRepository;
import com.example.CampusDeVerano.service.UsuarioService;
import org.springframework.stereotype.Service;
import java.lang.RuntimeException;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado"));
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario obtenerPerfil(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado"));
    }

    public Usuario actualizarPerfil(Integer id, Usuario datosActualizados) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario con ID " + id + " no encontrado"));

        // actualiza solo los campos editables
        //usuario.setNombre(datosActualizados.getNombre());
        //usuario.setTelefono(datosActualizados.getTelefono());
        //usuario.setDireccion(datosActualizados.getDireccion());
        //usuario.setCuilCuit(datosActualizados.getCuilCuit());

        return usuarioRepository.save(usuario);
    }
}
