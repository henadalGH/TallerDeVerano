package com.Resvas2025.Reserva.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Resvas2025.Reserva.model.Menu;
import com.Resvas2025.Reserva.model.Restaurante;



@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByRestaurante_Id(Integer restauranteId);

     // ULTIMOS CAMBIOS: Consulta JPQL para traer solo restaurantes únicos
    @Query("SELECT DISTINCT m.restaurante FROM Menu m WHERE m.tipoMenu = :tipoMenu")
    List<Restaurante> findRestaurantesByTipoMenu(@Param("tipoMenu") String tipoMenu);
}