package com.example.CampusDeVerano.repositorio;

import com.example.CampusDeVerano.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
