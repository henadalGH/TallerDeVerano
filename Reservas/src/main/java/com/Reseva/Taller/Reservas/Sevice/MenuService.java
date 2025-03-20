package com.Reseva.Taller.Reservas.Sevice;

import java.util.List;

import com.Reseva.Taller.Reservas.model.Menu;
import com.Reseva.Taller.Reservas.model.Plato;

public interface MenuService {
    public List<Menu> obtenerMenusPorRestaurante(Integer restauranteId);
    public Menu obtenerMenuPorRestaurante(Integer id);
    public Menu agregarMenu(Menu menu);
    public boolean eliminarMenu(Integer id);
    public List<Plato> obtenerPlatosPorMenu(Integer menuId);
}
