package com.Resvas2025.Reserva.Sevice;

import java.util.List;

import com.Resvas2025.Reserva.model.Reserva;



public interface ReservaService {

    public List<Reserva> obtenerTodas();
    public Reserva obtenerPorId(Integer id); 
    public Reserva guardar(Reserva reserva);
    public void eliminar(Integer id);
    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada);
    
}
