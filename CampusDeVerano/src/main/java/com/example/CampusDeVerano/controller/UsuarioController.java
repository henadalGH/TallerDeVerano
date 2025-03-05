package com.example.CampusDeVerano.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class UsuarioController {
    
    @GetMapping("/usu")
    public String holaMundo(){
        return "Hola mundo";
    }
}
