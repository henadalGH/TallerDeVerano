import { Component } from '@angular/core';
import { LoginService } from 'src/app/servicios/login/login-service.service';  // Importar el servicio
import { Router } from '@angular/router';  // Importar Router para redirigir después del login

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';  // Asegúrate de que esta propiedad esté definida
  password: string = '';  // Asegúrate de que esta propiedad esté definida

  constructor(private loginService: LoginService, private router: Router) {}

  // Método que se ejecuta al enviar el formulario
  onLogin() {
    const credentials = { email: this.email, password: this.password };  // Asegúrate de que las propiedades estén correctamente nombradas

    // Llamar al servicio para hacer login
    this.loginService.login(credentials).subscribe(
      response => {
        // Si el login es exitoso, guarda el token y redirige a la página principal
        localStorage.setItem('token', response.token);  // Guarda el token en el localStorage
        this.router.navigate(['/home']);  // Redirige a la página principal
      },
      error => {
        console.error('Error en el login', error);
        if (error.status === 403) {
          alert('Credenciales incorrectas o no autorizadas');  // Muestra un mensaje de error si la respuesta es fallida
        } else {
          alert('Hubo un error al procesar la solicitud');  // Otro tipo de error
        }
      }
    );
  }
}
