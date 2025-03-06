package com.example.CampusDeVerano.service;

import com.example.CampusDeVerano.model.Reserva;
import java.util.List;


public interface ReservaService {

    public List<Reserva> obtenerTodas();
    public Reserva obtenerPorId(Integer id); 
    public Reserva guardar(Reserva reserva);
    public void eliminar(Integer id);
    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada);
    
}
