package com.example.CampusDeVerano.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToMany(mappedBy = "platos")
    private List<Menu> menus;

}
