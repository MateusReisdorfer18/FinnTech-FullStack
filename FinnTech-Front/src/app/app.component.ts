import { Component } from '@angular/core';
import { IUser } from './model/interfaces/IUser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'FinnTech';
  usuarioLogado: boolean = false;
  user!: IUser;

  receberUser(user: IUser): void {
    this.user = user;
  }

  mostrar(): void {
    console.log(`
      Usuario: 
        email: ${this.user.email},
        senha: ${this.user.senha}
    `);
  }
}
