package com.ies.tallerVerano.reservaRestaurante.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario") 

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Integer id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 40, unique = true)
    private String email; 

    @Column(name = "contrasenia", length = 20)
    private String password; 

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "direccion", length = 40)
    private String direccion;

    @Column(name = "esAdmin")
    private boolean esAdmin; 

    @Column(name = "cuil_cuit", length = 13)
    private String cuilCuit;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;
}
