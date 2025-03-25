import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ServiceMenuService } from 'src/app/components/menu/service-menu.service';
import { AppModule, Menu } from 'src/app/app.module';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  menus: Menu[] = [];
  errorMessage: string = '';

  constructor(
    private route: ActivatedRoute,
    private menuService: ServiceMenuService
  ) {}

  ngOnInit(): void {
    const idRestaurante = Number(this.route.snapshot.paramMap.get('idRestaurante')); // Obtener el ID de la URL
    if (!isNaN(idRestaurante)) {
      this.cargarMenus(idRestaurante);
    } else {
      this.errorMessage = 'Restaurante no encontrado.';
    }
  }

  cargarMenus(idRestaurante: number) {
    this.menuService.obtenerMenusPorRestaurante(idRestaurante).subscribe(
      (data) => {
        this.menus = data;
      },
      (error) => {
        console.error('Error al obtener menús:', error);
        this.errorMessage = 'No se pudieron cargar los menús.';
      }
    );
  }
}
