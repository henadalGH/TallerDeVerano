package com.example.CampusDeVerano.dto;

public class AuthenticationResponce {
    
    private String jwt;

    public AuthenticationResponce(String jwt)
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
