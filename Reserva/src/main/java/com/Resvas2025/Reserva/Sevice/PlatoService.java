package com.Resvas2025.Reserva.Sevice;

import java.util.List;

import com.Resvas2025.Reserva.model.Menu;
import com.Resvas2025.Reserva.model.Plato;

public interface PlatoService {

    public List<Plato> obtenerTodosLosPlatos();
    public Plato obtenerPlatoPorId(Integer id);
    public Plato agregarPlato(Plato plato);
    public boolean eliminarPlato(Integer id);
    public List<Menu> obtenerMenusPorPlato(Integer platoId);
}
