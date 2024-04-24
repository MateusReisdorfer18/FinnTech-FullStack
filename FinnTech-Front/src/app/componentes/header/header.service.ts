import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IConta } from '../../model/interfaces/IConta';
import { LoginService } from '../login/login.service';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {

  constructor(private http: HttpClient, private loginService: LoginService) { }

  getAll(): Observable<IConta[]> {
    return this.http.get<IConta[]>('/api/contas/');
  }

  getByCliente(id: String): IConta[] {
    let contas!: IConta[];
    this.loginService.getContas(id).subscribe(
        (contasParam) => {
          contas = contasParam;
        }, (error: any) => {
          console.log(error);
        });

    return contas;
  }
}
