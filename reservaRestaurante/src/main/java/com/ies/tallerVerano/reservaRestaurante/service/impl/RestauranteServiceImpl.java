package com.ies.tallerVerano.reservaRestaurante.service.impl;

import com.ies.tallerVerano.reservaRestaurante.model.Restaurante;
import com.ies.tallerVerano.reservaRestaurante.repository.RestauranteRepository;
import com.ies.tallerVerano.reservaRestaurante.service.RestauranteService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImpl implements RestauranteService{
    private final RestauranteRepository restauranteRepository;

    public RestauranteServiceImpl(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante agregarRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante modificarRestaurante(Integer id, Restaurante restauranteModificado) {
        Restaurante restauranteExistente = restauranteRepository.findById(id).orElse(null);

        return restauranteRepository.save(restauranteExistente);
    }

    @Override
    public void eliminarRestaurante(Integer id) {
        restauranteRepository.deleteById(id);
    }
    

}
