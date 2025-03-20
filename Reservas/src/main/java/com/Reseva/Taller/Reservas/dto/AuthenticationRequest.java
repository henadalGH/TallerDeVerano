package com.Reseva.Taller.Reservas.dto;

public class AuthenticationRequest {
    private String nombre;
    private String password;


    public String getNombre(){
        return nombre;
    }

    public String getPassword(){
        return password;
    }

    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }

    public void setPassword(String password)
    {
        this.password=password;
    } 
}
