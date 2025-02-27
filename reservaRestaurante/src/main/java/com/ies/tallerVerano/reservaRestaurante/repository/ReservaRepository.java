package com.ies.tallerVerano.reservaRestaurante.repository;

import com.ies.tallerVerano.reservaRestaurante.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
}
