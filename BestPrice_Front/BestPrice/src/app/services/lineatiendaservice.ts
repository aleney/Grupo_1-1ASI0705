import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { environment } from '../../environments/environment';
import { LineatiendaList } from '../models/lineatiendalist';
import { LineatiendaInsert } from '../models/lineatiendainsert';
import { Lineatiendaanio2025 } from '../models/lineatiendaanio2025';
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class LineatiendaService {
  private url = `${base_url}/linea-tienda`;
  private listaLineaTienda = new Subject<LineatiendaList[]>();
  constructor(private http: HttpClient) {}
  
  list() {
    return this.http.get<LineatiendaList[]>(`${this.url}/listar`);
  }
  insert(lt: LineatiendaInsert) {
    return this.http.post(`${this.url}/insertar`, lt);
  }

  setList(listaNueva: LineatiendaList[]) {
    this.listaLineaTienda.next(listaNueva);
  }

  getList() {
    return this.listaLineaTienda.asObservable();
  }

  listId(id: number) {
    return this.http.get<LineatiendaList>(`${this.url}/listar/${id}`);
  }

  update(lt: LineatiendaInsert) {
    return this.http.put(`${this.url}/modificar`, lt, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<LineatiendaList[]>(`${this.url}/buscarnombre`, {params});
  }

  getTiendasAnioactual(): Observable<Lineatiendaanio2025[]> {
    return this.http.get<Lineatiendaanio2025[]>(`${this.url}/tiendas2025`);
  }

}