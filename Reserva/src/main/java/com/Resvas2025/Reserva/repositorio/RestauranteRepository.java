package com.Resvas2025.Reserva.repositorio;


import org.springframework.stereotype.Repository;

import com.Resvas2025.Reserva.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
