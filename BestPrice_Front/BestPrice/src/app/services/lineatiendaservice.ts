import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { Lineatiendamodel } from '../models/lineatiendamodel';
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class LineatiendaService {
  private url = `${base_url}/lineatiendas`;
  private listaLineaTienda = new Subject<Lineatiendamodel[]>();
  constructor(private http: HttpClient) {}
  
  list() {
    return this.http.get<Lineatiendamodel[]>(this.url);
  }
  insert(lt: Lineatiendamodel) {
    return this.http.post(this.url, lt);
  }
  setList(listaNueva: Lineatiendamodel[]) {
    this.listaLineaTienda.next(listaNueva);
  }
  getList() {
    return this.listaLineaTienda.asObservable();
  }
  listId(id: number) {
    return this.http.get<Lineatiendamodel>(`${this.url}/${id}`);
  }
  update(lt: Lineatiendamodel) {
    return this.http.put(`${this.url}`, lt, { responseType: 'text' });
  }
  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }
  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<Lineatiendamodel[]>(`${this.url}/buscarnombre`, {params});
  }

}