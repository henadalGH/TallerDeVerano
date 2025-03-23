package com.Resvas2025.Reserva.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Resvas2025.Reserva.model.MenuPlato;



public interface MenuPlatoRepository extends JpaRepository<MenuPlato, Integer> {
    List<MenuPlato> findByMenu_MenId(Integer menuId);
    List<MenuPlato> findByPlato_Id(Integer platoId);
}

