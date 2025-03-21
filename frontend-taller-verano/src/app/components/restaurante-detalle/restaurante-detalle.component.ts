import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServiceMenuService } from '../menu/service-menu.service'; // Ajustado a "../menu"

@Component({
  selector: 'app-restaurante-detalle',
  templateUrl: './restaurante-detalle.component.html',
  styleUrls: ['./restaurante-detalle.component.css']
})
export class RestauranteDetalleComponent implements OnInit {

  restaurante: any;
  loading = true;

  constructor(
    private route: ActivatedRoute,
    private menuService: ServiceMenuService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    this.menuService.getRestauranteById(id!).subscribe({
      next: (data) => {
        this.restaurante = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error al cargar detalle', err);
        this.loading = false;
      }
    });
  }

}

