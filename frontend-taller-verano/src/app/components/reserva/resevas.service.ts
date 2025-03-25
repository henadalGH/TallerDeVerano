import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResevasService {

  private apiUrl = 'http://localhost:8080/reservas';
  
  constructor(private http: HttpClient) { }
  
    
    crearReserva()
    {

    }
}
