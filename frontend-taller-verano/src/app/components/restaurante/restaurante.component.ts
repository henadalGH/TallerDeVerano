import { Component, OnInit } from '@angular/core';
import { ServiceRestauranteService } from './service-retaurante.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth-service.service';

@Component({
  selector: 'app-restaurante',
  templateUrl: './restaurante.component.html',
  styleUrls: ['./restaurante.component.css']
})
export class RestauranteComponent implements OnInit {
 
  restaurantes: any[] = [];
  loading: boolean = true;
  error: string | null = null;

  constructor(private restauranteService: ServiceRestauranteService, private router: Router, private authService: AuthService) { }

  irReserva() {
    if (this.authService.isLoggedIn()) {
      this.router.navigate(['/reservas']);  // Si el usuario está logueado, lo lleva a la página de reservas
    } else {
      this.router.navigate(['/login']);  // Si no está logueado, lo redirige al login
    }
  }

  irMenu(restauranteId: number) {
    this.router.navigate(['/menu', restauranteId]);  // Pasamos el ID del restaurante como parámetro
  }

  ngOnInit(): void {
    this.obtenerRestaurantes();
  }

  obtenerRestaurantes(): void {
    this.restauranteService.getRestaurantes().subscribe(
      (data) => {
        this.restaurantes = data;
        this.loading = false;
      },
      (err) => {
        this.error = 'Hubo un error al cargar los restaurantes';
        this.loading = false;
      }
    );
  }
}
