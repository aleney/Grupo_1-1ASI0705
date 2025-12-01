import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { TipoResena } from '../models/tiporesena';

const base_url=environment.base;
@Injectable({
  providedIn: 'root',
})

export class TipoResenaservice {
    private url = `${base_url}/tiporesena`;
  private listaCambio = new Subject<TipoResena[]>();
  constructor(private http: HttpClient) {}

  list(): Observable<TipoResena[]> {
    return this.http.get<TipoResena[]>(`${this.url}/listar`);
  }

  insert(resena: TipoResena) {
    return this.http.post(`${this.url}/Registrar`, resena);
  }

  update(resena: TipoResena) {
    return this.http.put(`${this.url}/editar`, resena);
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`);
  }

  listId(id: number): Observable<TipoResena> {
    return this.http.get<TipoResena>(`${this.url}/${id}`);
  }

  setList(lista: TipoResena[]) {
    this.listaCambio.next(lista);
  }

  getList() {
    return this.listaCambio.asObservable();
  }
  
  
}