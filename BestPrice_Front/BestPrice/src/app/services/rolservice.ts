import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { Rol } from '../models/rol';

const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class RolService {
  private url = `${base_url}/roles`;
  private listaRol = new Subject<Rol[]>();

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<Rol[]>(this.url);
  }

  insert(rol: Rol) {
    return this.http.post(this.url, rol);
  }

  update(rol: Rol) {
    return this.http.put(this.url, rol, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  listId(id: number) {
    return this.http.get<Rol>(`${this.url}/${id}`);
  }

  setList(listaNueva: Rol[]) {
    this.listaRol.next(listaNueva);
  }

  getList() {
    return this.listaRol.asObservable();
  }
}