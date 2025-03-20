package com.Reseva.Taller.Reservas.Sevice;

import java.util.List;
import com.Reseva.Taller.Reservas.model.Restaurante;

public interface RestauranteService {
    public List<Restaurante> obtenerTodosLosRestaurantes();
    public Restaurante obtenerRestaurantePorId(Integer id);
    public Restaurante agregarRestaurante(Restaurante restaurante);
    public boolean eliminarRestaurante(Integer id);
    public List<Restaurante> obtenerRestaurantesPorTipoMenu(String tipoMenu);
}
