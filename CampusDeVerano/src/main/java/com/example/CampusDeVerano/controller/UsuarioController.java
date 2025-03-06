package com.example.CampusDeVerano.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping 
public class UsuarioController {
    
    @GetMapping("/usuario")
    public String holaMundo(){
        return "Hola mundo";
    }
}
