package com.Resvas2025.Reserva.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Resvas2025.Reserva.model.Reserva;



@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
}
