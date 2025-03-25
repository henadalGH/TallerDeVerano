import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {

    // Si el usuario no está autenticado, redirige a la página de login
    if (!this.authService.isLoggedIn()) {
      this.router.navigate(['/login']);  // Redirige a la página de login
      return false;
    }

    // Si está logueado, permite el acceso a la página
    return true;
  }
}
