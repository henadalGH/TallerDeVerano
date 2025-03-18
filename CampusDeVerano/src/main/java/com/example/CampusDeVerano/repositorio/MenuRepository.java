package com.example.CampusDeVerano.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.CampusDeVerano.model.Menu;
import com.example.CampusDeVerano.model.Restaurante;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByRestaurante_Id(Integer restauranteId);

     // ULTIMOS CAMBIOS: Consulta JPQL para traer solo restaurantes únicos
    @Query("SELECT DISTINCT m.restaurante FROM Menu m WHERE m.tipoMenu = :tipoMenu")
    List<Restaurante> findRestaurantesByTipoMenu(@Param("tipoMenu") String tipoMenu);
}