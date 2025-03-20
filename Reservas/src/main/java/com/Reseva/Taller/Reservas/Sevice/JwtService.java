package com.Reseva.Taller.Reservas.Sevice;

import java.util.Date;
import java.security.Key;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "bWkgbWVqb3IgY2xhdmUgZXMgTWljYWVsYTIwMzBT"; // Clave en Base64
    private static final long EXPIRATION_IN_MINUTES = 60L; // 60 minutos

    // Método para generar un token JWT
    public String generateToken(UserDetails userDetails) {
        Date issueDate = new Date();
        Date expiration = new Date(System.currentTimeMillis() + EXPIRATION_IN_MINUTES * 60 * 1000);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(issueDate)
                .setExpiration(expiration)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Método para obtener la clave de firma
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
