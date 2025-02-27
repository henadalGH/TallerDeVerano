package com.ies.tallerVerano.reservaRestaurante.model;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "Menu") 

public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "men_id")
    private Integer men_id;

    @Column(name = "tipo_menu", length = 20)
    private String tipo_menu;

    @ManyToOne
    @JoinColumn(name = "ret_id", referencedColumnName = "ret_id") 
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "pla_id", referencedColumnName = "pla_id") 
    private Plato plato;

    @ManyToMany
    @JoinTable(name = "MenuPlato", joinColumns = @JoinColumn(name = "men_id"),
    inverseJoinColumns = @JoinColumn(name = "pla_id"))
    private List<Plato> listaPlato;
}

