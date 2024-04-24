import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { Cliente } from '../../model/classes/Cliente';
import { ICliente } from '../../model/interfaces/ICliente';
import { LoginService } from './login.service';
import { IClienteAutorizar } from '../../model/interfaces/IClienteAutorizar';
import { ClienteAutorizar } from '../../model/classes/ClienteAutorizar';
import { Observable, isEmpty, isObservable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  @Output() emitirCliente = new EventEmitter();
  @Input() tela!: String;

  emailEntrar: String = '';
  senhaEntrar: String = '';
  nomeCadastro: String = '';
  emailCadastro: String = '';
  senhaCadastro: String = '';
  cpfCadastro: String = '';
  // tela: String = "entrar";
  mensagemErro: boolean = false;

  constructor(private loginService: LoginService) {}

  enviarDados(): void {
    if(this.tela === "entrar") {
      this.loginService.autenticacao(this.emailEntrar, this.senhaEntrar).subscribe(
        (clienteParams) => {
          this.emitirClienteFunc(clienteParams);
        });
    }

    if(this.tela === "cadastro") {
      let cliente: ICliente = new Cliente();
      cliente.nome = this.nomeCadastro;
      cliente.email = this.emailCadastro;
      cliente.senha = this.senhaCadastro;
      cliente.cpf = this.cpfCadastro;
      this.loginService.create(cliente).subscribe();
      this.mudarTela();
    }
  }

  emitirClienteFunc(cliente: ICliente): void {
    if(cliente)
      this.emitirCliente.emit(cliente);
  }

  mudarTela(): void {
    if(this.tela === "entrar") {
      this.tela = "cadastro";
      this.limparAtributos(this.tela);
      this.verificarBotao();
      return;
    }

    if(this.tela === "cadastro") {
      this.tela = "entrar";
      this.limparAtributos(this.tela);
      this.verificarBotao();
      return;
    }
  }

  private limparAtributos(tipo: String): void {
    if(tipo === "entrar") {
      this.emailEntrar = "";
      this.senhaEntrar = "";
    }

    if(tipo === "cadastro") {
      this.nomeCadastro = "";
      this.emailCadastro = "";
      this.senhaCadastro = "";
      this.cpfCadastro = "";
    }
  }

  private verificarBotaoEntrar(): boolean {
    if((this.emailEntrar === "") || (this.senhaEntrar === "")) {
      return false;
    } else {
      return true;
    }
  }

  private verificarBotaoCadastro(): boolean {
      if((this.nomeCadastro === "") || 
        (this.emailCadastro === "") || 
        (this.senhaCadastro === "") || 
        (this.cpfCadastro === "")) 
      {
        return false;
      } else {
        return true;
      }
  }  

  verificarBotao(): boolean {
    if(this.tela === "entrar") 
      return this.verificarBotaoEntrar();

    if(this.tela === "cadastro")
      return this.verificarBotaoCadastro();

    return false;
  }
}
