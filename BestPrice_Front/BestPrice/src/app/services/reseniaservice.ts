import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { Resenia } from '../models/resenia';
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class ReseniaService {
  private url = `${base_url}/resena`;
  private listaResenia = new Subject<Resenia[]>();
  constructor(private http: HttpClient) {}
  
  list() {
    return this.http.get<Resenia[]>(`${this.url}/listar`);
  }
  insert(r: Resenia) {
    return this.http.post(`${this.url}/insertar`, r);
  }
  setList(listaNueva: Resenia[]) {
    this.listaResenia.next(listaNueva);
  }
  getList() {
    return this.listaResenia.asObservable();
  }

  listId(id: number) {
    return this.http.get<Resenia>(`${this.url}/listar/${id}`);
  }
  update(r: Resenia) {
    return this.http.put(`${this.url}/modificar`, r, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  /* 
  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<Resenia[]>(`${this.url}/busquedas`, { params });
  }
  */
}
