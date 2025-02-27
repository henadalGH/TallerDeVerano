package com.ies.tallerVerano.reservaRestaurante.repository;

import com.ies.tallerVerano.reservaRestaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{
    
}
