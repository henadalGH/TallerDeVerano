package com.Resvas2025.Reserva.Sevice;

import java.util.List;

import com.Resvas2025.Reserva.model.Restaurante;


public interface RestauranteService {
    public List<Restaurante> obtenerTodosLosRestaurantes();
    public Restaurante obtenerRestaurantePorId(Integer id);
    public Restaurante agregarRestaurante(Restaurante restaurante);
    public boolean eliminarRestaurante(Integer id);
    public List<Restaurante> obtenerRestaurantesPorTipoMenu(String tipoMenu);
}
