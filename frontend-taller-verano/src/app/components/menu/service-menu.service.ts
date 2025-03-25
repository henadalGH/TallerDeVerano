import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppModule, Menu } from 'src/app/app.module';

@Injectable({
  providedIn: 'root'
})
export class ServiceMenuService {
  private apiUrl = 'http://localhost:8080/menus/restaurante/**';

  constructor(private http: HttpClient) {}

  obtenerMenusPorRestaurante(restauranteId: number): Observable<Menu[]> {
    return this.http.get<Menu[]>(`${this.apiUrl}/restaurante/${restauranteId}`);
  }
}
