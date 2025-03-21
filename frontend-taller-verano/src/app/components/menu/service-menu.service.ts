import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceMenuService {

  private apiUrl = 'https://tudominio.com/api/restaurantes'; // Cambialo por el real

  constructor(private http: HttpClient) { }

  getRestaurantes(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getRestauranteById(id: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }
  
}
