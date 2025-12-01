import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../../environments/environment';
import { UsuarioList } from '../models/usuariolist';
import { Usuarioinsert } from '../models/usuarioinsert';


const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private url = `${base_url}/usuarios`;
  private listaUsuario = new Subject<UsuarioList[]>();

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<UsuarioList[]>(this.url);
  }

  insert(usuario: Usuarioinsert) {
    return this.http.post(this.url, usuario);
  }

  update(usuario: Usuarioinsert) {
    return this.http.put(this.url, usuario, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  listId(id: number) {
    return this.http.get<UsuarioList>(`${this.url}/${id}`);
  }

  listIdInsert(id: number) {
    return this.http.get<Usuarioinsert>(`${this.url}/insert/${id}`);
  }

  setList(listaUsuario: UsuarioList[]) {
    this.listaUsuario.next(listaUsuario);
  }

  getList() {
    return this.listaUsuario.asObservable();
  }

  searchName(nombre: string) {
    const params = { n: nombre };
    return this.http.get<UsuarioList[]>(`${this.url}/buscarnombre`, { params });
  }
}