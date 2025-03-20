package com.Reseva.Taller.Reservas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.Reseva.Taller.Reservas.Sevice.JwtService;



@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    // Esta ruta manejará el GET de la página de login
    @GetMapping("/login")
    public ResponseEntity<String> showLoginPage() {
        // Aquí podrías devolver el HTML del formulario de login
        String loginForm = "<html>" +
                "<body>" +
                "<h2>Login</h2>" +
                "<form action='/auth/login' method='POST'>" +
                "Correo: <input type='email' name='correo' required><br>" +
                "Contraseña: <input type='password' name='contrasena' required><br>" +
                "<input type='submit' value='Login'>" +
                "</form>" +
                "</body>" +
                "</html>";
        return ResponseEntity.ok(loginForm);
    }

    // Esta ruta manejará el POST cuando el usuario envíe el formulario de login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String correo, @RequestParam String contrasena) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(correo, contrasena)
        );

        if (authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(token); // Regresar el token JWT
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}


