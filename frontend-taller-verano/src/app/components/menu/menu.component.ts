import { Component, OnInit } from '@angular/core';
import { ServiceMenuService } from './service-menu.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  restaurantes: any[] = [];
  loading = true;

  constructor(private menuService: ServiceMenuService) { }

  ngOnInit(): void {
    this.menuService.getRestaurantes().subscribe({
      next: (data) => {
        this.restaurantes = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error al cargar restaurantes', err);
        this.loading = false;
      }
    });
  }
}

