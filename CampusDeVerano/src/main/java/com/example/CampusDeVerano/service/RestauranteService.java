package com.example.CampusDeVerano.service;

import com.example.CampusDeVerano.model.Restaurante;
import java.util.List;

public interface RestauranteService {
    public List<Restaurante> obtenerTodosLosRestaurantes();
    public Restaurante obtenerRestaurantePorId(Integer id);
    public Restaurante agregarRestaurante(Restaurante restaurante);
    public boolean eliminarRestaurante(Integer id);
    public List<Restaurante> obtenerRestaurantesPorTipoMenu(String tipoMenu);
}
