package com.example.CampusDeVerano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.CampusDeVerano.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
}