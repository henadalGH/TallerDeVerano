import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Menu } from 'src/app/app.module';  // Asegúrate de que 'Menu' esté bien importado desde el lugar adecuado.

@Injectable({
  providedIn: 'root'
})
export class ServiceMenuService {
  private apiUrl = 'http://localhost:8080/menus/restaurante';  // Base URL

  constructor(private http: HttpClient) {}

  obtenerMenusPorRestaurante(restauranteId: number): Observable<Menu[]> {
    // Aquí, construimos la URL correctamente con el restauranteId
    return this.http.get<Menu[]>(`${this.apiUrl}/restaurante/${restauranteId}`);
  }
}
