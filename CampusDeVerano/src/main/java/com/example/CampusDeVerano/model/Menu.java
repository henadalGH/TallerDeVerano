package com.example.CampusDeVerano.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
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
    @JsonIgnore 
    private Restaurante restaurante;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MenuPlato> menuPlatos;

}
