import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { Canasta } from '../models/canasta';
const base_url = environment.base;


@Injectable({
  providedIn: 'root',
})

export class CanastaService {
  private url = `${base_url}/canasta`;
  private listaCambio = new Subject<Canasta[]>();
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Canasta[]>(`${this.url}/listar`);
  }

  insert(c: Canasta) {
    return this.http.post(`${this.url}/insertar`, c);
  }

  setList(listaNueva: Canasta[]) {
    this.listaCambio.next(listaNueva);
  }

  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<Canasta>(`${this.url}/${id}`);
  }

  update(c: Canasta) {
    return this.http.put(`${this.url}/modificar`, c, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  searchName(nombre: string) {
    const params = { n: nombre };
    return this.http.get<Canasta[]>(`${this.url}/buscar`, { params });
  }
}
