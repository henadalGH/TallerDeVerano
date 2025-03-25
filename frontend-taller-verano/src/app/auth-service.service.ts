import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private storageKey = 'authToken';  // Clave para el almacenamiento

  constructor() {}

  // Método para verificar si el usuario está logueado
  isLoggedIn(): boolean {
    return !!localStorage.getItem(this.storageKey);  // Devuelve true si hay un token en el localStorage
  }

  // Método para iniciar sesión (simulado)
  login() {
    localStorage.setItem(this.storageKey, 'token');  // Aquí deberías guardar un token real
  }

  // Método para cerrar sesión (simulado)
  logout() {
    localStorage.removeItem(this.storageKey);  // Elimina el token del localStorage
  }
}
