package com.Reseva.Taller.Reservas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Reseva.Taller.Reservas.model.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
}
