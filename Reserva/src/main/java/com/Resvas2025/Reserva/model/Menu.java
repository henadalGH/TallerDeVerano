package com.Resvas2025.Reserva.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "men_id") 
    private Integer menId;

    @Column(name = "tipo_menu", length = 20, nullable = false)
    private String tipoMenu;

    @ManyToOne
    @JoinColumn(name = "ret_id", nullable = false)
    @JsonBackReference  // Asegura que la relación con Restaurante no cause un ciclo infinito
    private Restaurante restaurante;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<MenuPlato> menuPlatos;
}
