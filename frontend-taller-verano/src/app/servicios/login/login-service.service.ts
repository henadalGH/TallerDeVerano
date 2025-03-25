// login.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',  // Asegura que el servicio esté disponible globalmente
})
export class LoginService {

  private apiUrl = 'http://localhost:8080/auth/login';  // Cambia la URL por la de tu backend

  constructor(private http: HttpClient) {}

  // Este método ahora recibe email y password por separado
  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(this.apiUrl, { correo: email, contrasena: password });
  }

  setToken(token: string): void {
    localStorage.setItem('token', token);  // Guarda el token en el almacenamiento local o en otro lugar
  }
}
