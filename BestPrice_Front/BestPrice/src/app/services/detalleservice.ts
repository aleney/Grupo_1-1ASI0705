import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../../environments/environment';
import { Detalle } from '../models/detalle';  // Importamos el modelo
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class DetalleService {
   private url = `${base_url}/detalle`;
    private listaCambio = new Subject<Detalle[]>();
    constructor(private http: HttpClient) {}
  
    list() {
      return this.http.get<Detalle[]>(`${this.url}/listar`);
    }
  
    insert(d: Detalle) {
      return this.http.post(`${this.url}/insertar`, d);
    }
  
    setList(listaNueva: Detalle[]) {
      this.listaCambio.next(listaNueva);
    }
  
    getList() {
      return this.listaCambio.asObservable();
    }
  
    listId(id: number) {
      return this.http.get<Detalle>(`${this.url}/${id}`);
    }
  
    update(d: Detalle) {
      return this.http.put(`${this.url}/modificar`, d, { responseType: 'text' });
    }
  
    delete(id: number) {
      return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
    }
  
    searchName(nombre: string) {
      const params = { n: nombre };
      return this.http.get<Detalle[]>(`${this.url}/buscar`, { params });
    }
   }
  
