import { Component, OnInit } from '@angular/core';
import { ServiceRestauranteService } from './service-retaurante.service';

@Component({
  selector: 'app-restaurante',
  templateUrl: './restaurante.component.html',
  styleUrls: ['./restaurante.component.css']
})
export class RestauranteComponent implements OnInit {
  restaurantes: any[] = [];
  loading: boolean = true;
  error: string | null = null;

  constructor(private restauranteService: ServiceRestauranteService) { }

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
