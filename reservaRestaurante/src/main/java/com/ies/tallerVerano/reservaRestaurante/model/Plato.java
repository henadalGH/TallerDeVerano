package com.ies.tallerVerano.reservaRestaurante.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Plato") 

public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pla_id") 
    private Integer id;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false)
    private Integer precio;

    @Column(length = 40)
    private String descripcion;

    @Column(length = 40)
    private String imagen;

    @Column(length = 20)
    private String categoria;

    @OneToMany(mappedBy = "plato")
    private List<Menu> menus;

    @ManyToMany(mappedBy = "plato")
    private List<Menu> listaMenus;
}

