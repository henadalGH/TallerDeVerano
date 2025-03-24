import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceRestauranteService {
  private apiUrl = 'http://localhost:8080/restaurantes/lista';

  constructor(private http: HttpClient) { }

  getRestaurantes(): Observable<any[]> { 
    return this.http.get<any[]>(this.apiUrl); // Asegúrate de que esto sea un Observable
  }
}
