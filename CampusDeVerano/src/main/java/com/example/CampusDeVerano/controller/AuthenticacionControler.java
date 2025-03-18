package com.example.CampusDeVerano.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CampusDeVerano.dto.AuthenticationReques;
import com.example.CampusDeVerano.dto.AuthenticationResponce;
import com.example.CampusDeVerano.service.AuthenticacionService;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/authen")
public class AuthenticacionControler {

    private AuthenticacionService authenticationService;

    @PostMapping("/autenticaser")
    public ResponseEntity<AuthenticationResponce> login(@RequestBody  AuthenticationReques authRequest){
        AuthenticationResponce jwt = authenticationService.login(authRequest);
        return ResponseEntity.ok(jwt);
    }

    
    


}
