package com.Resvas2025.Reserva.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Resvas2025.Reserva.Sevice.AuthenticationService;
import com.Resvas2025.Reserva.model.dto.AuthenticationRequest;
import com.Resvas2025.Reserva.model.dto.AuthenticationResponse;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private final AuthenticationService authenticationService;

    public UsuarioController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Método para autenticar al usuario
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest authenticationRequest) {    
        AuthenticationResponse rsp = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(rsp);
    }

    // Método para cerrar sesión
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        // Eliminar el token en el cliente, pero aquí invalidamos el token en el servidor
        authenticationService.logout(token.replace("Bearer ", ""));
        return ResponseEntity.ok("Sesión cerrada exitosamente");
    }
}
