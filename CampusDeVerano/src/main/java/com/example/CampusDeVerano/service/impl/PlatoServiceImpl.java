package com.example.CampusDeVerano.service.impl;

import com.example.CampusDeVerano.model.Menu;
import com.example.CampusDeVerano.model.MenuPlato;
import com.example.CampusDeVerano.model.Plato;
import com.example.CampusDeVerano.repositorio.MenuPlatoRepository;
import com.example.CampusDeVerano.repositorio.PlatoRepository;
import com.example.CampusDeVerano.service.PlatoService;
import org.springframework.stereotype.Service;
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
