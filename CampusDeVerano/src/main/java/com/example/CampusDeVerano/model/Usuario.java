package com.example.CampusDeVerano.model;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;




@Entity

@NoArgsConstructor

@Table(name = "usuario")
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String telefono;

    @Column(name = "es_admin", nullable = false)
private Boolean esAdmin;

    @Column(nullable = false)
    private String contrasenia;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  
    private List<Reserva> reservas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorna una colección de autoridades (roles). Si es administrador, se le asigna el rol "ADMIN"
        if (esAdmin) {
            return Collections.singletonList(() -> "ROLE_ADMIN");
        } else {
            return Collections.singletonList(() -> "ROLE_USER");
        }
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Puedes personalizar este comportamiento según tu lógica
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Puedes personalizar este comportamiento según tu lógica
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Puedes personalizar este comportamiento según tu lógica
    }

    @Override
    public boolean isEnabled() {
        return true;  // Puedes personalizar este comportamiento según tu lógica
    }
}
