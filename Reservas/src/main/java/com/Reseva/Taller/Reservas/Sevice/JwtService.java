package com.Reseva.Taller.Reservas.Sevice;

import java.security.Key;
import java.sql.Date;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "bWkgbWVqb3IgY2xhdmUgZXMgTWljYWVsYTIwMzBT"; // Clave codificada en Base64
    private Long EXPIRATION_INMINUTE = 60L; // Asegúrate de definir este valor adecuadamente

    // Método para generar el token JWT sin extraClims
    public String generateToken(UserDetails userDetails) {
        Date issueDate = new Date(System.currentTimeMillis());
        Date expiration = new Date((EXPIRATION_INMINUTE * 60 * 1000) + issueDate.getTime());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(issueDate)
                .setExpiration(expiration)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Método privado para generar la clave de firma
    private Key generateKey() {
        byte[] decodedKey = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    // Método para extraer el nombre de usuario desde el JWT
    public String extractUsername(String jwt) {
        return extractAllClaims(jwt).getSubject();
    }

    // Método privado para extraer todos los claims del JWT
    private Claims extractAllClaims(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(generateKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
}
