import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { HeaderService } from './header.service';
import { ICliente } from '../../model/interfaces/ICliente';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  @Input() cliente!: ICliente;
  @Output() telaEntrar = new EventEmitter();
  @Output() telaCadastro = new EventEmitter();

  constructor(private headerService: HeaderService) {}

  mudarTelaEntrar(): void {
    this.telaEntrar.emit();
  }

  mudarTelaCadastro(): void {
    this.telaCadastro.emit();
  }
}
