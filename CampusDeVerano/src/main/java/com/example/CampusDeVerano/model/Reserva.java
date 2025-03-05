package com.example.CampusDeVerano.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usu_id", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
        name = "reserva_menu", // Tabla intermedia
        joinColumns = @JoinColumn(name = "reserva_id"),
        inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menus;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
