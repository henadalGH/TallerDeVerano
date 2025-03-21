import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestauranteDetalleComponent } from './components/restaurante-detalle/restaurante-detalle.component';


const routes: Routes = [
  // Otras rutas...
  { path: 'restaurante/:id', component: RestauranteDetalleComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

