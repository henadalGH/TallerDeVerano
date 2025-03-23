package com.Resvas2025.Reserva.Component;

import org.springframework.stereotype.Component;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Resvas2025.Reserva.Sevice.JwtService;
import com.Resvas2025.Reserva.Sevice.UsuarioService;
import com.Resvas2025.Reserva.model.Usuario;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;  // Importar la anotación NonNull
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioService usuarioService;

    public JwtAuthenticationFilter(JwtService jwtService, UsuarioService usuarioService) {
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("ENTRO EN EL FILTRO JWT AUTHENTICATION FILTER");

        // 1. Obtener encabezado http llamado Authorization (Formato: "Bearer jwt")
        String authorizationHeader = request.getHeader("Authorization");

        if (!StringUtils.hasText(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);  // Continuar con la cadena de filtros si no hay token
            return;
        }

        // 2. Obtener token JWT desde el encabezado
        String jwt = authorizationHeader.split(" ")[1];

        // 3. Obtener el subject/username desde el token
        // Esta acción también valida el formato del token, firma y fecha de expiración
        String username = jwtService.extractUsername(jwt);

        // 4. Verificar que el token es válido y no está vacío
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Buscar el usuario en la base de datos
            Usuario usuario = usuarioService.findByCorreo(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con correo: " + username));

            // Crear un token de autenticación
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    usuario, null, usuario.getAuthorities());

            // Setear detalles adicionales en el token
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // 5. Establecer la autenticación en el contexto de seguridad
            SecurityContextHolder.getContext().setAuthentication(authToken);

            System.out.println("Se acaba de setear el authentication");
        }

        // 6. Continuar con el filtro
        filterChain.doFilter(request, response);
    }
}
