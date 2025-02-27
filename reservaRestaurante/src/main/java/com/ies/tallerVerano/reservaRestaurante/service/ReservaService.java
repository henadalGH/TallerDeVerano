package com.ies.tallerVerano.reservaRestaurante.service;

import org.springframework.stereotype.Service;
import com.ies.tallerVerano.reservaRestaurante.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository = null;

    public void cancelarReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}
