import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RestauranteDetalleComponent } from './components/restaurante-detalle/restaurante-detalle.component';
import { LoginComponent } from './components/login/login.component';
import { MenuComponent } from './components/menu/menu.component';




const routes: Routes = [
  { path: '', redirectTo: '/menu', pathMatch: 'full' },  // Redirige a login por defecto
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: '/menu' },  // Redirige a login si la ruta no existe
  { path: 'menu', component: MenuComponent},
  { path: 'restaurante', component: RestauranteDetalleComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
