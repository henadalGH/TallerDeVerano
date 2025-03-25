package com.Resvas2025.Reserva.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.Resvas2025.Reserva.Component.JwtAuthenticationFilter;
import com.Resvas2025.Reserva.Sevice.impl.UsuarioServiceImpl;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    // Configuración del AuthenticationManager como un Bean
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        // Pasar el UsuarioService que implementa UserDetailsService
        authenticationManagerBuilder.userDetailsService(usuarioService);

        return authenticationManagerBuilder.build();
    }

    // Configuración de CORS
    @Bean
public CorsFilter corsFilter() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("http://localhost:4200");  // Para desarrollo, en producción pon el dominio de tu frontend
    corsConfiguration.addAllowedMethod("*");  // Puedes especificar los métodos si es necesario
    corsConfiguration.addAllowedHeader("*");  // Permite todos los encabezados, ajusta si es necesario
    corsConfiguration.addExposedHeader("Authorization");  // Exponer el encabezado Authorization
    corsConfiguration.setAllowCredentials(true);  // Habilitar el envío de credenciales

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);  // Aplica la configuración a todas las rutas

    return new CorsFilter(source);
}

    // Configuración del SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrfConfig -> csrfConfig.disable()) // Desactiva la protección CSRF
            .sessionManagement(sessMagConfig -> 
                sessMagConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Configura la política de creación de sesión como stateless
            .authenticationManager(authenticationManager(http)) // Configura el AuthenticationManager
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Añade el filtro JWT antes del filtro de autenticación
            .addFilterBefore(corsFilter(), JwtAuthenticationFilter.class) // Agrega el filtro CORS
            .authorizeHttpRequests(authReqConfig -> {  // Configuración de autorización de rutas
                // Endpoints públicos (sin autenticación)
                authReqConfig
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // URL de login pública
                    .requestMatchers(HttpMethod.GET, "/reservas").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN") // Acceso solo a usuarios con los roles USER o ADMIN
                    .requestMatchers(HttpMethod.GET,"/restaurantes/lista").permitAll()
                    .requestMatchers(HttpMethod.GET,"/menus/restaurante/{restauranteId}").permitAll()
                    .requestMatchers(HttpMethod.GET,"/platos").permitAll()
                    .requestMatchers(HttpMethod.GET, "restaurante/{id}").hasAnyAuthority("ROLE_ADMIN")
                    .requestMatchers(HttpMethod.POST, "/restaurantes").hasAnyAuthority("ROLE_ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/restaurantes/{id}").hasAnyAuthority("ROLE_ADMIN")
                    ;

                // Requiere autenticación para el resto de las solicitudes
                authReqConfig.anyRequest().authenticated();
            });

        return http.build(); // Retorna el filtro de seguridad configurado
    }
}
