package com.example.CampusDeVerano.service;

import com.example.CampusDeVerano.model.Menu;
import com.example.CampusDeVerano.model.Plato;

import java.util.List;

public interface MenuService {
    public List<Menu> obtenerMenusPorRestaurante(Integer restauranteId);
    public Menu obtenerMenuPorRestaurante(Integer id);
    public Menu agregarMenu(Menu menu);
    public boolean eliminarMenu(Integer id);
    // ULTIMOS CAMBIOS:
    public List<Plato> obtenerPlatosPorMenu(Integer menuId);
}
