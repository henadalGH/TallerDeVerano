package com.example.CampusDeVerano.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "men_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "res_id", nullable = false)
    private Restaurante restaurante;

    @ManyToMany
    @JoinTable(
        name = "menu_plato", // Tabla intermedia
        joinColumns = @JoinColumn(name = "menu_id"),
        inverseJoinColumns = @JoinColumn(name = "plato_id")
    )
    private List<Plato> platos;

}
