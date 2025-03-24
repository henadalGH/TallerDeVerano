import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceRestauranteService {
  private apiUrl = 'http://localhost:8080/restaurantes/lista'; // Ajusta la URL si es necesario

  constructor(private http: HttpClient) { }

  getRestaurantes(): Observable<any[]> { // 👈 Debe devolver un Observable
    return this.http.get<any[]>(this.apiUrl);
  }
}
