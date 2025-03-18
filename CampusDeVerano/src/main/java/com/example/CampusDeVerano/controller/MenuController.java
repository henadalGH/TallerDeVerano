package com.example.CampusDeVerano.controller;

import com.example.CampusDeVerano.model.Menu;
import com.example.CampusDeVerano.model.Plato;
import com.example.CampusDeVerano.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/restaurante/{restauranteId}")
    public ResponseEntity<List<Menu>> obtenerMenusPorRestaurante(@PathVariable Integer restauranteId) {
        List<Menu> menus = menuService.obtenerMenusPorRestaurante(restauranteId);

        if (menus.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 si no hay menús
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