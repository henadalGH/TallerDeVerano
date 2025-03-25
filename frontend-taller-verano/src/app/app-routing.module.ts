import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { MenuComponent } from './components/menu/menu.component';
import { AuthGuard } from './auth.guard';
import { ReservaComponent } from './components/reserva/reserva.component';
import { RestauranteComponent } from './components/restaurante/restaurante.component';



const routes: Routes = [
  { path: '', redirectTo: '/restaurante', pathMatch: 'full' },  // Redirige a login por defecto
  { path: 'login', component: LoginComponent },
  { path: 'menu', component: MenuComponent},
  { path: 'restaurante', component: RestauranteComponent},
  { path: 'reserva', component: ReservaComponent },
  { path: 'menu/:idRestaurante', component: MenuComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
