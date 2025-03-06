package com.example.CampusDeVerano.service;

import com.example.CampusDeVerano.model.Reserva;
import com.example.CampusDeVerano.repositorio.ReservaRepository;
import org.springframework.stereotype.Service;
import java.lang.RuntimeException;
import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    public Reserva obtenerPorId(Integer id) {
        return reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void eliminar(Integer id) {
        if (!reservaRepository.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        reservaRepository.deleteById(id);
    }

    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada) {
        Reserva reservaExistente = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva con ID " + id + " no encontrada"));
    
        // Actualizamos solo los campos necesarios
          //reservaExistente.setTurno(reservaActualizada.getTurno());
          //reservaExistente.setCantidadPersona(reservaActualizada.getCantidadPersona());
          //reservaExistente.setRestaurante(reservaActualizada.getRestaurante());
        reservaExistente.setUsuario(reservaActualizada.getUsuario());
    
        return reservaRepository.save(reservaExistente);
    }
    
}
