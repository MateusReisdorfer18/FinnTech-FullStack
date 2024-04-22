import { Component } from '@angular/core';
import { IBanco } from '../../model/interfaces/IBanco';
import { BancoService } from './banco.service';
import { Banco } from '../../model/classes/Banco';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-banco',
  templateUrl: './banco.component.html',
  styleUrl: './banco.component.scss'
})
export class BancoComponent {
  idBanco:String = "";
  bancos: IBanco[] = [];
  banco!: IBanco;
  nomeBanco: String = '';
  novoBanco!: Banco;
  exibirBanco: Boolean = false;
  statusListar: Boolean = false;

  constructor(private bancoService: BancoService) {}

  listarTodos(): void {
    this.bancoService.getall().subscribe((bancos) => this.bancos = bancos);
    this.statusListar = !this.statusListar;
  }

  buscarPorId(): void {
    this.bancoService.getById(this.idBanco).subscribe((banco) => this.banco = banco);
    this.exibirBanco = true;
  }
 
  cadastrar(): void {
    this.novoBanco = new Banco();
    this.novoBanco.nome = this.nomeBanco;
    this.bancoService.create(this.novoBanco).subscribe();
    this.listarTodos();
  }

  fecharBancoEncontrado(): void {
    this.exibirBanco = !this.exibirBanco;
  }
}
