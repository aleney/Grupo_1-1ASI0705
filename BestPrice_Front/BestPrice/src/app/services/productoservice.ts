import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { ProductoList } from '../models/productolist';
import { ProductoInsert } from '../models/productoinsert';

const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class Productoservice {
  private url = `${base_url}/producto`;
  private listaproducto = new Subject<ProductoList[]>();
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<ProductoList[]>(`${this.url}/listar`);
  }

  insert(p: ProductoInsert) {
    return this.http.post(`${this.url}/Registrar`, p);
  }

  setList(listaN: ProductoList[]) {
    this.listaproducto.next(listaN);
  }

  getList() {
    return this.listaproducto.asObservable();
  }

  listId(id: number) {
    return this.http.get<ProductoList>(`${this.url}/${id}`);
  }

  update(p: ProductoInsert) {
    return this.http.put(`${this.url}/editar`, p, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
