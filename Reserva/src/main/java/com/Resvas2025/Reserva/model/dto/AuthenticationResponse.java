package com.Resvas2025.Reserva.model.dto;

public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse(String jwt)
    {
        this.jwt=jwt;
    }

    public String getJwt()
    {
        return jwt;
    }

    public void setJwt(String jwt)
    {
        this.jwt=jwt;
    }
}
