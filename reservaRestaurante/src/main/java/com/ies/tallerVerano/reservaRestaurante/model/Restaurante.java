package com.ies.tallerVerano.reservaRestaurante.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Restaurante") 

public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ret_id")
    private Integer id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(name = "num_suc", nullable = false)
    private Integer numSucursales;

    @Column(nullable = false, length = 40, unique = true)
    private String email;

    @Column(nullable = false, length = 40)
    private String direccion;

    @Column(nullable = false)
    private Integer telefono;

    @Column(length = 20)
    private String turno;

    @Column(length = 40)
    private String imagen;

    @Column(nullable = false)
    private Boolean estacionamiento;

    @Column(nullable = false)
    private Boolean accesibilidad;

    @OneToMany(mappedBy = "restaurante")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "restaurante")
    private List<Menu> menus;
}

