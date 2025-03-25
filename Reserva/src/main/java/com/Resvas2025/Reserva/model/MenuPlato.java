package com.Resvas2025.Reserva.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonBackReference
    private Menu menu; 

    @ManyToOne
    @JoinColumn(name = "pla_id", nullable = false)
    @JsonManagedReference
    private Plato plato; 
}
