package com.Reseva.Taller.Reservas.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true) 
    private String correo;

    @Column(nullable = false)
    private String contrasenia;

    private Integer telefono;

    private String direccion;
    
    @Column(name = "es_admin")
    private Boolean esAdmin;
    
    @Column(name = "cuil_cuit")
    private String cuilCuit;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Reserva> reservas;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
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
        return true;  
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  
    }

    @Override
    public boolean isEnabled() {
        return true; 
    }
}
