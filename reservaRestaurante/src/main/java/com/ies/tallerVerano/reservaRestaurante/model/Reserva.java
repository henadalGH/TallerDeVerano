package com.ies.tallerVerano.reservaRestaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Reserva")

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id") 
    private Integer id;

    @Column(length = 20)
    private String turno;

    @Column(name = "cantidad_persona", nullable = false)
    private Integer cantidadPersonas;

    @ManyToOne
    @JoinColumn(name = "usu_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ret_id", referencedColumnName = "id")
    private Usuario restaurante;
}
