import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn = false;  // Aquí podrías usar un sistema real de autenticación, como un token

  constructor() {}

  // Método para verificar si el usuario está logueado
  isLoggedIn() {
    return this.loggedIn;  // Aquí se puede agregar lógica para verificar el estado de sesión
  }

  // Método para iniciar sesión (simulado)
  login() {
    this.loggedIn = true;
  }

  // Método para cerrar sesión (simulado)
  logout() {
    this.loggedIn = false;
  }
}
