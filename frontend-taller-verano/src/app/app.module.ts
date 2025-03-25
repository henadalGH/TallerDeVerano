import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

// Componentes
import { RestauranteComponent } from './components/restaurante/restaurante.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { MenuComponent } from './components/menu/menu.component';
import { PlatoComponent } from './components/plato/plato.component';
import { LoginComponent } from './components/login/login.component';
import { ServiceRestauranteService } from './components/reserva/service-restaurante.service';

// Importar módulos necesarios para formularios y HTTP
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    ReservaComponent,
    UsuarioComponent,
    MenuComponent,
    PlatoComponent,
    LoginComponent,
    RestauranteComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule, // Necesario para el manejo de formularios
    HttpClientModule
     // Necesario para realizar peticiones HTTP
  ],
  providers: [ServiceRestauranteService],
  bootstrap: [AppComponent]
})
export class AppModule { }

export interface Menu {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number;
  restauranteId: number;
}