package com.Reseva.Taller.Reservas.Sevice;

import java.util.List;
import com.Reseva.Taller.Reservas.model.Menu;
import com.Reseva.Taller.Reservas.model.Plato;

public interface PlatoService {

    public List<Plato> obtenerTodosLosPlatos();
    public Plato obtenerPlatoPorId(Integer id);
    public Plato agregarPlato(Plato plato);
    public boolean eliminarPlato(Integer id);
    public List<Menu> obtenerMenusPorPlato(Integer platoId);
}
