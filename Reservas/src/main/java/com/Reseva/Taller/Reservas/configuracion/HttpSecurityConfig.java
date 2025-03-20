package com.Reseva.Taller.Reservas.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Reseva.Taller.Reservas.component.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
    
    @Autowired
    private AuthenticationProvider daoAuthProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración principal de seguridad
        return http
            
            .csrf(csrf -> csrf.disable())  // Deshabilitar CSRF ya que estamos trabajando con JWT
            .sessionManagement(sessMagConfig -> 
                sessMagConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sesión sin estado
            .authenticationProvider(daoAuthProvider) // Proveedor de autenticación
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Filtro JWT antes del filtro de usuario
            .authorizeHttpRequests(authReqConfig -> buildRequestMatchers(authReqConfig))  // Configurar las reglas de autorización
            .build();  // Construir el SecurityFilterChain
    }

    private void buildRequestMatchers(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authReqConfig) {
        
        // Permitir acceso a la ruta /login sin autenticación
        authReqConfig.requestMatchers(HttpMethod.GET, "/auth/login").permitAll();
        authReqConfig.requestMatchers(HttpMethod.GET, "/munus/restaurante/{restauranteId}").permitAll();

        authReqConfig.requestMatchers(HttpMethod.POST, "/auth/login").permitAll();
        
        // Resto de las peticiones requieren autenticación
        authReqConfig.requestMatchers(HttpMethod.GET, "/menus").hasRole("USER");
        
        // Cualquier otra petición requiere autenticación
        authReqConfig.anyRequest().authenticated();
    }
    
}
