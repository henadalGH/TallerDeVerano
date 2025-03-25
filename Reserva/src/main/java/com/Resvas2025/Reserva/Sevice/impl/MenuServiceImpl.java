package com.Resvas2025.Reserva.Sevice.impl;

import org.springframework.stereotype.Service;

import com.Resvas2025.Reserva.Sevice.MenuService;
import com.Resvas2025.Reserva.model.Menu;
import com.Resvas2025.Reserva.model.MenuPlato;
import com.Resvas2025.Reserva.model.Plato;
import com.Resvas2025.Reserva.repositorio.MenuPlatoRepository;
import com.Resvas2025.Reserva.repositorio.MenuRepository;

import java.lang.RuntimeException;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    
    private final MenuRepository menuRepository;
    private final MenuPlatoRepository menuPlatoRepository;

    public MenuServiceImpl(MenuRepository menuRepository, MenuPlatoRepository menuPlatoRepository) {
        this.menuRepository = menuRepository;
        this.menuPlatoRepository = menuPlatoRepository;
    }

    public List<Menu> obtenerMenusPorRestaurante(Integer restauranteId) {
        return menuRepository.findByRestaurante_Id(restauranteId);
    }

    public Menu obtenerMenuPorRestaurante(Integer id) {
        Menu menu = menuRepository.findById(id).orElse(null);
        if (menu == null) {
            throw new RuntimeException("Menú no encontrado");
        }
        return menu;
    }

    public Menu agregarMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public boolean eliminarMenu(Integer id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Menú no encontrado");
    }

    public List<Plato> obtenerPlatosPorMenu(Integer menuId) {
        List<MenuPlato> menuPlatos = menuPlatoRepository.findByMenu_MenId(menuId);
        return menuPlatos.stream()
                         .map(MenuPlato::getPlato) // Extraer solo los platos
                         .toList();
    }

    @Override
    public List<Menu> obtenerMenusCompletosPorRestaurante(Integer restauranteId) {
        List<Menu> menus = menuRepository.findByRestaurante_Id(restauranteId);

        menus.forEach(menu -> menu.setMenuPlatos(
            menuPlatoRepository.findByMenu_MenId(menu.getMenId())
        ));

        return menus;
    }


}
