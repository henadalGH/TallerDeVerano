package com.Resvas2025.Reserva.Sevice;

import java.util.List;
import com.Resvas2025.Reserva.model.Menu;
import com.Resvas2025.Reserva.model.Plato;


public interface MenuService {
    public List<Menu> obtenerMenusPorRestaurante(Integer restauranteId);
    public Menu obtenerMenuPorRestaurante(Integer id);
    public Menu agregarMenu(Menu menu);
    public boolean eliminarMenu(Integer id);
    public List<Plato> obtenerPlatosPorMenu(Integer menuId);
    public List<Menu> obtenerMenusCompletosPorRestaurante(Integer restauranteId);
}
