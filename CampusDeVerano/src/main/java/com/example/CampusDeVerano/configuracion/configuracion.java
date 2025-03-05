package com.example.CampusDeVerano.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class configuracion {

    @Autowired
    AuthenticationConfiguration AuthenticationConfiguration;
    
    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity seguridad) throws Exception
    {
        return seguridad.build();
    }

    @Bean
    public AuthenticationManager AuthenticationManager() throws Exception
    {
        return AuthenticationConfiguration.getAuthenticationManager();
    } 


    public AuthenticationProvider AuthenticationProvider()
    {
        DaoAuthenticationProvider authenticationStrategy = new DaoAuthenticationProvider();
        authenticationStrategy.setPasswordEncoder(null);
        authenticationStrategy.setUserDetailsPasswordService(null);

        return authenticationStrategy;

    }

    @Bean
    public PasswordEncoder passwwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
