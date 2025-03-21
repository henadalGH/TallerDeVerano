import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RestauranteComponent } from './components/restaurante/restaurante.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { UsuarioComponent } from './components/usuario/usuario.component';
import { MenuComponent } from './components/menu/menu.component';
import { PlatoComponent } from './components/plato/plato.component';
import { RestauranteDetalleComponent } from './components/components/restaurante/restaurante-detalle/restaurante-detalle.component';

@NgModule({
  declarations: [
    AppComponent,
    RestauranteComponent,
    ReservaComponent,
    UsuarioComponent,
    MenuComponent,
    PlatoComponent,
    RestauranteDetalleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
