package com.Resvas2025.Reserva.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plato")
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

    @OneToMany(mappedBy = "plato", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MenuPlato> menuPlatos;

}
