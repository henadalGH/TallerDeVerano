package com.Reseva.Taller.Reservas.Sevice.impl;

import org.springframework.stereotype.Service;

import com.Reseva.Taller.Reservas.Sevice.ReservaService;
import com.Reseva.Taller.Reservas.model.Reserva;
import com.Reseva.Taller.Reservas.repositorio.ReservaRepository;
import java.lang.RuntimeException;
import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {
    
    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva obtenerPorId(Integer id) {
        return reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminar(Integer id) {
        if (!reservaRepository.existsById(id)) {
            throw new RuntimeException("Reserva no encontrada");
        }
        reservaRepository.deleteById(id);
    }

    @Override
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


