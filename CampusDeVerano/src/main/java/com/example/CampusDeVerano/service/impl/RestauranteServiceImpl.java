package com.example.CampusDeVerano.service.impl;

import com.example.CampusDeVerano.model.Restaurante;
import com.example.CampusDeVerano.repositorio.MenuRepository;
import com.example.CampusDeVerano.repositorio.RestauranteRepository;
import com.example.CampusDeVerano.service.RestauranteService;
import org.springframework.stereotype.Service;
import java.lang.RuntimeException;
import java.util.List;

@Service
public class RestauranteServiceImpl implements RestauranteService {
    
    private final RestauranteRepository restauranteRepository;
    private final MenuRepository menuRepository;

    public RestauranteServiceImpl(RestauranteRepository restauranteRepository, MenuRepository menuRepository) {
        this.restauranteRepository = restauranteRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Restaurante> obtenerTodosLosRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante obtenerRestaurantePorId(Integer id) {
        Restaurante restaurante = restauranteRepository.findById(id).orElse(null);
        if (restaurante == null) {
            throw new RuntimeException("Restaurante no encontrado");
        }
        return restaurante;
    }

    @Override
    public Restaurante agregarRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }
    
    @Override
    public boolean eliminarRestaurante(Integer id) {
        if (restauranteRepository.existsById(id)) {
            restauranteRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Restaurante no encontrado");
    }
    
    // ULTIMOS CAMBIOS: Filtrar restaurantes por tipo de menú
    public List<Restaurante> obtenerRestaurantesPorTipoMenu(String tipoMenu) {
            return menuRepository.findRestaurantesByTipoMenu(tipoMenu);
    }
}