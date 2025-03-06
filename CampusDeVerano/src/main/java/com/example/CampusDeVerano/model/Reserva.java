package com.example.CampusDeVerano.model;

import jakarta.persistence.*;
import lombok.*;

// import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usu_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Integer cantidad_persona;

    @Column(nullable = false)
    private String turno;
    
}
