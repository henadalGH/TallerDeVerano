package com.Resvas2025.Reserva.Sevice;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.sql.Date;
import java.util.Map;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-in-minutos}")
    private Long EXIRACION_CLAVE;

    @Value("${security.jwt.clave-secreta}")
    private String CLAVE_SECRETA;

    public String generateToken(UserDetails user, Map<String, Object> extraClains)
    {
        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + 30L * 24L * 60L * 60L * 1000L); // 30 días en milisegundos

        String jwt = Jwts.builder()
            .setClaims(extraClains)
            .setSubject(user.getUsername())
            .setIssuedAt(issuedAt)
            .setExpiration(expiration)
            .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
            .signWith(generateKey(), SignatureAlgorithm.HS256)
            .compact();

        return jwt;
    }

    private Key generateKey(){
        byte[] keyBytes = Base64.getDecoder().decode(CLAVE_SECRETA); // ✅ Decodificación correcta
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Renombramos el método para que coincida con la llamada en el filtro
    public String extractUsername(String jwt) {
        return extractAllClaims(jwt).getSubject(); 
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts.parserBuilder()
            .setSigningKey(generateKey())
            .build()
            .parseClaimsJws(jwt)
            .getBody();
    }
}
