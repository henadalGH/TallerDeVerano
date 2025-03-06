package com.example.CampusDeVerano.controller;

import com.example.CampusDeVerano.model.Reserva;
import com.example.CampusDeVerano.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // obtener todas las reservas
    @GetMapping
    public List<Reserva> obtenerTodas() {
        return reservaService.obtenerTodas();
    }

    // obtener reserva por su id
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerPorId(@PathVariable Integer id) {
        Reserva reserva = reservaService.obtenerPorId(id);
        return ResponseEntity.ok(reserva);
    }

    // crear una nueva reserva
    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        Reserva nuevaReserva = reservaService.guardar(reserva);
        return ResponseEntity.ok(nuevaReserva);
    }

    // actualiza una reserva que ya existe en el sistema
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Integer id, @RequestBody Reserva reservaActualizada) {
        Reserva reservaGuardada = reservaService.actualizarReserva(id, reservaActualizada);
        return ResponseEntity.ok(reservaGuardada);
    }

    // elimina una reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Integer id) {
        reservaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
