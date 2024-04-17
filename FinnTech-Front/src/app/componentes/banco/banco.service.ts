import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, take } from 'rxjs';
import { IBanco } from './IBanco';
import { Banco } from './Banco';

@Injectable({
  providedIn: 'root'
})
export class BancoService {

  constructor(private http: HttpClient) { }

  getall(): Observable<IBanco[]> {
    return this.http.get<IBanco[]>('/api/bancos/');
  }

  getById(id:String): Observable<IBanco> {
    return this.http.get<IBanco>(`/api/bancos/${id}`);
  }

  create(banco: Banco): Observable<Banco> {
    return this.http.post<Banco>('/api/bancos/cadastro', banco);
  }
}
