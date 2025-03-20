package com.Reseva.Taller.Reservas.Sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.Reseva.Taller.Reservas.dto.AuthenticationRequest;
import com.Reseva.Taller.Reservas.dto.AuthenticationResponse;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    // Método login para autenticar al usuario y generar un token JWT
    public AuthenticationResponse login(AuthenticationRequest authRequest) {

        // Paso 1: Autenticar al usuario con nombre y contraseña
        UsernamePasswordAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(authRequest.getNombre(), authRequest.getPassword());
        
        // Autenticación usando AuthenticationManager
        authenticationManager.authenticate(authenticationToken);

        // Paso 2: Obtener detalles del usuario desde UsuarioService
        UserDetails userDetails = usuarioService.findByCorreo(authRequest.getNombre())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Paso 3: Generar el token JWT
        String jwt = jwtService.generateToken(userDetails);

        // Paso 4: Crear y devolver la respuesta con el JWT
        AuthenticationResponse authResponse = new AuthenticationResponse(jwt);
        authResponse.setJwt(jwt);

        return authResponse;
    }
}
