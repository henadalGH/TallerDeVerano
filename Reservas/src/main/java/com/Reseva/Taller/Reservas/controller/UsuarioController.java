package com.Reseva.Taller.Reservas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Reseva.Taller.Reservas.Sevice.AuthenticationService;
import com.Reseva.Taller.Reservas.dto.AuthenticationRequest;
import com.Reseva.Taller.Reservas.dto.AuthenticationResponse;


@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authRequest) {
        AuthenticationResponse response = authenticationService.login(authRequest);
        return ResponseEntity.ok(response);
    }
}
