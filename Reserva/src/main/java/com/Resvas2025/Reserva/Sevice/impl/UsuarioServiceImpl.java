package com.Resvas2025.Reserva.Sevice.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.Resvas2025.Reserva.Sevice.UsuarioService;
import com.Resvas2025.Reserva.model.Usuario;
import com.Resvas2025.Reserva.repositorio.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService, org.springframework.security.core.userdetails.UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor para inyectar las dependencias
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario por correo
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(username);
        
        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con correo: " + username);
        }

        Usuario usuario = usuarioOpt.get();

        // Devolver el usuario como un objeto User de Spring Security
        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getContrasenia()) // Aquí, Spring Security maneja la encriptación
                .authorities(usuario.getAuthorities()) // Obtener las autoridades desde el Usuario
                .build();
    }

    // El resto de los métodos que ya tenías
    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNoEncontradoException(id));
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByCorreo(usuario.getCorreo());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia())); // Encriptar la contraseña
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerPerfil(Integer id) {
        return obtenerPorId(id);
    }

    @Override
    public Usuario actualizarPerfil(Integer id, Usuario datosActualizados) {
        validarContrasenia(datosActualizados);
        Usuario usuarioExistente = obtenerPorId(id);
        usuarioExistente.setNombre(datosActualizados.getNombre());
        usuarioExistente.setCorreo(datosActualizados.getCorreo());
        usuarioExistente.setContrasenia(passwordEncoder.encode(datosActualizados.getContrasenia())); // Encriptar contraseña
        return usuarioRepository.save(usuarioExistente);
    }

    private void validarContrasenia(Usuario usuario) {
        String password = usuario.getContrasenia();
        if (password == null || password.length() < 6) {
            throw new RuntimeException("La contraseña debe tener al menos 6 caracteres");
        }
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public static class UsuarioNoEncontradoException extends RuntimeException {
        public UsuarioNoEncontradoException(Integer id) {
            super("Usuario con ID " + id + " no encontrado");
        }
    }
}
