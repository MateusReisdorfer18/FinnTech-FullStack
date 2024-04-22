import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IConta } from '../../model/interfaces/IConta';

@Injectable({
  providedIn: 'root'
})
export class HeaderService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<IConta[]> {
    return this.http.get<IConta[]>('/api/contas/');
  }
}
