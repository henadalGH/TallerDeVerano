package com.Resvas2025.Reserva.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ret_id") 
    private Integer id;

    @Column(nullable = false, length = 20) 
    private String nombre;

    @Column(name = "num_suc", nullable = false) 
    private Integer numSucursal;

    @Column(nullable = false, length = 40, unique = true) 
    private String email;

    @Column(nullable = false, length = 40)
    private String direccion;

    @Column(nullable = false) 
    private String telefono;

    @Column(length = 20)
    private String turno;

    @Column(length = 40)
    private String imagen;

    @Column(nullable = false) 
    private boolean estacionamiento;

    @Column(nullable = false) 
    private boolean accesibilidad;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Asegura que los menús se serialicen correctamente
    private List<Menu> menus;
}
