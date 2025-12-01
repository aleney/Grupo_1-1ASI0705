import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../../environments/environment';
import { DistritoListModel } from '../models/distritolist';
import { DistritoInsertModel } from '../models/distritoinsert';

const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class DistritoService {
  private url = `${base_url}/distrito`;
  private listaCambio = new Subject<DistritoListModel[]>();
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<DistritoListModel[]>(`${this.url}/listar`);
  }

  insert(d: DistritoInsertModel) {
    return this.http.post(`${this.url}/insertar`, d);
  }

  setList(listaNueva: DistritoListModel[]) {
    this.listaCambio.next(listaNueva);
  }

  getList() {
    return this.listaCambio.asObservable();
  }

  listId(id: number) {
    return this.http.get<DistritoListModel>(`${this.url}/${id}`);
  }

  update(d: DistritoInsertModel) {
    return this.http.put(`${this.url}/modificar`, d, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  searchName(nombre: string) {
    const params = { n: nombre };
    return this.http.get<DistritoListModel[]>(`${this.url}/busquedas`, { params });
  }
}