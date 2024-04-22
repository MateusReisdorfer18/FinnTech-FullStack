import { Component, OnInit } from '@angular/core';
import { IConta } from '../../model/interfaces/IConta';
import { HeaderService } from './header.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {
  nome:String = "Mateus";
  saldo: Number = 5500;
  contas!: IConta[];

  constructor(private headerService: HeaderService) {}

  ngOnInit(): void {
    this.headerService.getAll().subscribe((contas) => this.contas = contas); 
  }

  verContas(): void {
    this.contas.forEach((conta) => {
      console.log(`
        Id: ${conta.id}
        Tipo: ${conta.tipoConta.tipo}
        Cliente: ${conta.cliente.nome}
        Numero: ${conta.numero}
        Saldo: ${conta.saldo}
        Banco: ${conta.banco.nome}
        `);
    });
  }
}
