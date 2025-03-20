package com.Reseva.Taller.Reservas.Sevice;

import java.util.List;
import com.Reseva.Taller.Reservas.model.Reserva;


public interface ReservaService {

    public List<Reserva> obtenerTodas();
    public Reserva obtenerPorId(Integer id); 
    public Reserva guardar(Reserva reserva);
    public void eliminar(Integer id);
    public Reserva actualizarReserva(Integer id, Reserva reservaActualizada);
    
}
