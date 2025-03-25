import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResevasService {
  private apiUrl = 'http://localhost:8080/reservas'; // URL de la API

  constructor(private http: HttpClient) {}

  // Método corregido: Retorna un Observable
  crearReserva(reserva: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}`, reserva);
  }
}

