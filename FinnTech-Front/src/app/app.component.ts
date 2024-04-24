import { Component, EventEmitter, Output } from '@angular/core';
import { ICliente } from './model/interfaces/ICliente';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  title = 'FinnTech';
  usuarioLogado: boolean = true;
  cliente!: ICliente;
  tela!: String;

  receberUser(cliente: ICliente): void {
    this.cliente = cliente;
    
    if(this.cliente)
      this.usuarioLogado = !this.usuarioLogado;
    console.log(this.cliente);
  }

  telaEntrar(): void {
    this.usuarioLogado = false;
    this.tela = "entrar";
  }

  telaCadastro(): void {
    this.usuarioLogado = false;
    this.tela = "cadastro";
  }
}
