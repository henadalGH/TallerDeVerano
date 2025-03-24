package com.Resvas2025.Reserva.Sevice;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import com.Resvas2025.Reserva.model.Usuario;
import com.Resvas2025.Reserva.model.dto.AuthenticationRequest;
import com.Resvas2025.Reserva.model.dto.AuthenticationResponse;
import java.util.HashMap;
import java.util.Map;


@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService userService;
    private final JwtService jwtService;
    
    // Aquí almacenamos los tokens "revocados" si implementamos una lista negra (opcional)
    private final Map<String, String> revokedTokens = new HashMap<>();

    // Constructor para inyectar dependencias
    public AuthenticationService(AuthenticationManager authenticationManager, UsuarioService userService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    // Método para realizar el login
    public AuthenticationResponse login(AuthenticationRequest autRequest) {
        // Crear un objeto de autenticación con las credenciales del usuario (correo y contraseña)
        Authentication authentication = new UsernamePasswordAuthenticationToken(
            autRequest.getCorreo(),  // Usamos el correo para la autenticación
            autRequest.getContrasena()  // Usamos la contraseña
        );

        try {
            // Autenticar al usuario con el AuthenticationManager
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Credenciales incorrectas", e);
        }

        // Recuperar el usuario desde el servicio usando el correo
        UserDetails user = userService.findByCorreo(autRequest.getCorreo())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Asegurarse de que el usuario es una instancia de Usuario
        if (user instanceof Usuario) {
            Usuario usuario = (Usuario) user;

            // Generar el token JWT con los claims
            String jwt = jwtService.generateToken(usuario, generateExtraClaims(usuario));

            // Aquí imprimimos el JWT generado en la consola
            System.out.println("Generated JWT: " + jwt);

            // Crear la respuesta con el JWT usando el constructor con parámetros
            AuthenticationResponse authRsp = new AuthenticationResponse(jwt);
            return authRsp;
        } else {
            throw new RuntimeException("Tipo de usuario no válido");
        }
    }

    // Método para generar los claims adicionales (puedes adaptarlo según tus necesidades)
    private Map<String, Object> generateExtraClaims(Usuario user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getAuthorities().toString());  // Agregamos el rol del usuario
        claims.put("userId", user.getId());
        claims.put("nombre", user.getNombre());
        return claims;
    }

    // Método para hacer logout
    public void logout(String token) {
        // Si tienes un sistema de lista negra de tokens, puedes invalidar el token aquí.
        revokedTokens.put(token, "revoked");
        System.out.println("Token invalidado: " + token);
    }

    // Verifica si un token está revocado (opcional)
    public boolean isTokenRevoked(String token) {
        return revokedTokens.containsKey(token);
    }
}
