package com.Reseva.Taller.Reservas.Sevice.impl;

import org.springframework.stereotype.Service;

import com.Reseva.Taller.Reservas.Sevice.PlatoService;
import com.Reseva.Taller.Reservas.model.Menu;
import com.Reseva.Taller.Reservas.model.MenuPlato;
import com.Reseva.Taller.Reservas.model.Plato;
import com.Reseva.Taller.Reservas.repositorio.MenuPlatoRepository;
import com.Reseva.Taller.Reservas.repositorio.PlatoRepository;


import java.lang.RuntimeException;
import java.util.List;

@Service
public class PlatoServiceImpl implements PlatoService {
    
    private final PlatoRepository platoRepository;
    private final MenuPlatoRepository menuPlatoRepository;

    public PlatoServiceImpl(PlatoRepository platoRepository, MenuPlatoRepository menuPlatoRepository) {
        this.platoRepository = platoRepository;
        this.menuPlatoRepository = menuPlatoRepository;
    }

    public List<Plato> obtenerTodosLosPlatos() {
        return platoRepository.findAll();
    }

    public Plato obtenerPlatoPorId(Integer id) {
        Plato plato = platoRepository.findById(id).orElse(null);
        if (plato == null) {
            throw new RuntimeException("Plato no encontrado");
        }
        return plato;
    }

    public Plato agregarPlato(Plato plato) {
        return platoRepository.save(plato);
    }

    public boolean eliminarPlato(Integer id) {
        if (platoRepository.existsById(id)) {
            platoRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Plato no encontrado");
    }

    public List<Menu> obtenerMenusPorPlato(Integer platoId) {
        List<MenuPlato> menuPlatos = menuPlatoRepository.findByPlato_Id(platoId);
        return menuPlatos.stream()
                        .map(MenuPlato::getMenu) // Extraer solo los menús
                        .toList();
    }
    
}
