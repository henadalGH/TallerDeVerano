package com.Reseva.Taller.Reservas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Reseva.Taller.Reservas.Sevice.RestauranteService;
import com.Reseva.Taller.Reservas.model.Restaurante;


import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public List<Restaurante> obtenerTodos() {
        return restauranteService.obtenerTodosLosRestaurantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(restauranteService.obtenerRestaurantePorId(id));
    }

    // ULTIMOS CAMBIOS: Filtrar por tipo de menú
    @GetMapping("/filtrar")
    public ResponseEntity<List<Restaurante>> filtrarPorTipoMenu(@RequestParam String tipoMenu) {
        return ResponseEntity.ok(restauranteService.obtenerRestaurantesPorTipoMenu(tipoMenu));
    }

    @PostMapping
    public ResponseEntity<Restaurante> agregar(@RequestBody Restaurante restaurante) {
        return new ResponseEntity<>(restauranteService.agregarRestaurante(restaurante), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        restauranteService.eliminarRestaurante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Restaurante> obtenerDetalle(@PathVariable Integer id) {
        Restaurante restaurante = restauranteService.obtenerRestaurantePorId(id);
        return ResponseEntity.ok(restaurante);
    }
}
