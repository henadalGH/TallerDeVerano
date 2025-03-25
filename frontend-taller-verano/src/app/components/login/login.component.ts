// login.component.ts
import { Component } from '@angular/core';
import { LoginService } from 'src/app/servicios/login/login-service.service'; // Asegúrate de que la ruta es correcta
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  constructor(private loginService: LoginService, private router: Router) {}

  onLogin(): void {
    console.log('Datos de login:', this.email, this.password);  // Imprime el correo y la contraseña

    // Llamar al servicio con dos parámetros (email y password)
    this.loginService.login(this.email, this.password).subscribe(
      (response) => {
        this.loginService.setToken(response.token);
        this.router.navigate(['/reserva']);
      },
      (error) => {
        console.error('Error de login', error);
        alert('Correo o contraseña incorrectos');
      }
    );
  }
}

