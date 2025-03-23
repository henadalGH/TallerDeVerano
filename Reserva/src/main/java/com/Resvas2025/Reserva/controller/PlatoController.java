package com.Resvas2025.Reserva.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Resvas2025.Reserva.Sevice.PlatoService;
import com.Resvas2025.Reserva.model.Menu;
import com.Resvas2025.Reserva.model.Plato;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public ResponseEntity<List<Plato>> obtenerTodos() {
        return ResponseEntity.ok(platoService.obtenerTodosLosPlatos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plato> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(platoService.obtenerPlatoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Plato> agregar(@RequestBody Plato plato) {
        return new ResponseEntity<>(platoService.agregarPlato(plato), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        platoService.eliminarPlato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{platoId}/menus")
    public ResponseEntity<List<Menu>> obtenerMenusPorPlato(@PathVariable Integer platoId) {
        List<Menu> menus = platoService.obtenerMenusPorPlato(platoId);
        return menus.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(menus);
    }
}
