import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { CategoriaProducto } from '../models/categoriaproducto';

const base_url = environment.base;
@Injectable({
  providedIn: 'root'
})
export class Categoriaproductoservice {
  private url = `${base_url}/categoria-producto`;
  private listaCatProducto = new Subject<CategoriaProducto[]>();
  constructor(private http: HttpClient) {}
  
  list() {
    return this.http.get<CategoriaProducto[]>(`${this.url}/listar`);
  }

  insert(lt: CategoriaProducto) {
    return this.http.post(`${this.url}/insertar`, lt);
  }

  setList(listaNueva: CategoriaProducto[]) {
    this.listaCatProducto.next(listaNueva);
  }

  getList() {
    return this.listaCatProducto.asObservable();
  }

  listId(id: number) {
    return this.http.get<CategoriaProducto>(`${this.url}/listar/${id}`);
  }

  update(lt: CategoriaProducto) {
    return this.http.put(`${this.url}/editar`, lt, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<CategoriaProducto[]>(`${this.url}/buscarnombre`, {params});
  }
}