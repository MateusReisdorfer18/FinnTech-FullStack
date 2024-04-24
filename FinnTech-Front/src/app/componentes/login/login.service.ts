import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IConta } from '../../model/interfaces/IConta';
import { ICliente } from '../../model/interfaces/ICliente';
import { Cliente } from '../../model/classes/Cliente';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  autenticacao(email: String, senha: String): Observable<Cliente> {
    return this.http.get<Cliente>(`api/clientes/autorizar/${email}/${senha}`);
  }

  getAll(): Observable<ICliente[]> {
    return this.http.get<ICliente[]>('/api/clientes/');
  }

  getById(id: String): Observable<ICliente> {
    return this.http.get<ICliente>(`/api/clientes/${id}`);
  }

  getContas(id: String): Observable<IConta[]> {
    return this.http.get<IConta[]>(`/api/clientes/listarcontas/${id}`);
  }

  create(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>('/api/clientes/cadastrar', cliente);
  }
}
