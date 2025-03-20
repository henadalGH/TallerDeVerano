package com.Reseva.Taller.Reservas.repositorio;


import org.springframework.stereotype.Repository;

import com.Reseva.Taller.Reservas.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
