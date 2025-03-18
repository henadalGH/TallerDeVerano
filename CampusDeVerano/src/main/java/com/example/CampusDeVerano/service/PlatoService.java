package com.example.CampusDeVerano.service;

import com.example.CampusDeVerano.model.Menu;
import com.example.CampusDeVerano.model.Plato;
import java.util.List;

public interface PlatoService {

    public List<Plato> obtenerTodosLosPlatos();
    public Plato obtenerPlatoPorId(Integer id);
    public Plato agregarPlato(Plato plato);
    public boolean eliminarPlato(Integer id);
    public List<Menu> obtenerMenusPorPlato(Integer platoId);
}
