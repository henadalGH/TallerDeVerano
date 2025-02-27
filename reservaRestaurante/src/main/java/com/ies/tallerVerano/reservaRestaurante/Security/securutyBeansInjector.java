package com.ies.tallerVerano.reservaRestaurante.Security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ies.tallerVerano.reservaRestaurante.repository.UsuarioRepository;

@Configuration
public class securutyBeansInjector<AuthenticationCofiguration, AuthenticationManager> {
    


@Autowired
private AuthenticationCofiguration authenticationCofiguration; 

@Autowired
private UsuarioRepository usuarioRepository;

@Bean
public AuthenticationManager authenticationManager() throws Exception{
    return authenticationCofiguration.getAuthenticationManager();
} 
}

