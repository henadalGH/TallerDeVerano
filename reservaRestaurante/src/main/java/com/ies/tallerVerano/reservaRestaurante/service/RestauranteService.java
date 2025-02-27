package com.ies.tallerVerano.reservaRestaurante.service;


import java.util.List;

import com.ies.tallerVerano.reservaRestaurante.model.Restaurante;

public interface RestauranteService {
    List<Restaurante> listarRestaurantes();
    Restaurante agregarRestaurante(Restaurante nuevoRestaurante);
    Restaurante modificarRestaurante(Integer id, Restaurante restauranteModificado);
    void eliminarRestaurante(Integer id);
}
