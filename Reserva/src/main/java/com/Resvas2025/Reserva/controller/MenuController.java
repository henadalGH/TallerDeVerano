package com.Resvas2025.Reserva.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Resvas2025.Reserva.Sevice.MenuService;
import com.Resvas2025.Reserva.model.Menu;
import com.Resvas2025.Reserva.model.Plato;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<Menu>> obtenerMenusCompletosPorRestaurante(@PathVariable Integer restauranteId) {
        List<Menu> menus = menuService.obtenerMenusCompletosPorRestaurante(restauranteId);

        if (menus.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(menus);
    }


    @PostMapping
    public ResponseEntity<Menu> agregarMenu(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.agregarMenu(menu), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMenu(@PathVariable Integer id) {
        menuService.eliminarMenu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{menuId}/platos")
    public ResponseEntity<List<Plato>> obtenerPlatosPorMenu(@PathVariable Integer menuId) {
        List<Plato> platos = menuService.obtenerPlatosPorMenu(menuId);
        return platos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(platos);
    }

}