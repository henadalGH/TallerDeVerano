package com.Resvas2025.Reserva.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Resvas2025.Reserva.repositorio.UsuarioRepository;

@Configuration
public class SecurityConfig {

    // Atributo de tipo UsuarioRepository para acceder a los datos de usuario
    private final UsuarioRepository usuarioRepository;

    // Constructor para inyectar la dependencia de UsuarioRepository
    public SecurityConfig(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Definición del proveedor de autenticación (AuthenticationProvider)
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // Instanciación de un DaoAuthenticationProvider
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        
        // Configuración del codificador de contraseñas
        provider.setPasswordEncoder(passwordEncoder());

        // Configuración del servicio de detalles del usuario
        provider.setUserDetailsService(userDetailsService());

        // Retorna el proveedor de autenticación configurado
        return provider;
    }

    // Método para definir el codificador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Retorna un codificador de contraseñas BCrypt
        return new BCryptPasswordEncoder();
    }

    // Método para definir el servicio de detalles del usuario
    @Bean
    public UserDetailsService userDetailsService() {
        // El servicio busca al usuario por su correo
        return correo -> usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("El usuario con correo " + correo + " no existe"));
    }
}
