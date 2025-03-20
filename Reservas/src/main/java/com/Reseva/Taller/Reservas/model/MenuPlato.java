package com.Reseva.Taller.Reservas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menuplato")
public class MenuPlato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "munpla_id") 
    private Integer id; 

    @ManyToOne
    @JoinColumn(name = "men_id", nullable = false)
    private Menu menu; 

    @ManyToOne
    @JoinColumn(name = "pla_id", nullable = false)
    private Plato plato; 
}
