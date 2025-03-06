package com.example.CampusDeVerano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CampusDeVerano.model.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {
}