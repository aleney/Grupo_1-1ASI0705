import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Producto } from '../models/producto';

const base_url = environment.base;
@Injectable({
  providedIn: 'root',
})
export class Productoservice {
  private url = `${base_url}/producto`;
  private listaproducto = new Subject<Producto[]>();
  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Producto[]>(this.url);
  }
  insert(p: Producto) {
    return this.http.post(`${this.url}/Registrar`, p);
  }
  setList(listaN: Producto[]) {
    this.listaproducto.next(listaN);
  }
  getList() {
    return this.listaproducto.asObservable();
  }
  listId(id: number) {
    return this.http.get<Producto>(`${this.url}/${id}`);
  }
  update(p: Producto) {
    return this.http.put(`${this.url}`, p, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
}
