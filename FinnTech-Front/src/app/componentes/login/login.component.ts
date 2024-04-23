import { Component, EventEmitter, Output } from '@angular/core';
import { User } from '../../model/classes/User';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  emailEntrar!: String;
  senhaEntrar!: String;
  nomeCadastro!: String;
  emailCadastro!: String;
  senhaCadastro!: String;
  cpfCadastro!: String;
  tela: String = "cadastro";

  @Output() emitirCliente = new EventEmitter();

  enviarDados(): void {
    let cliente: User = new User();
    cliente.email = this.emailEntrar;
    cliente.senha = this.senhaEntrar;
    this.emitirCliente.emit(cliente);
  }

  mudarTela(): void {
    if(this.tela === "entrar") {
      this.tela = "cadastro";
      console.log(this.tela);
      return;
    }

    if(this.tela === "cadastro") {
      this.tela = "entrar";
      console.log(this.tela);
      return;
    }
  }
}
