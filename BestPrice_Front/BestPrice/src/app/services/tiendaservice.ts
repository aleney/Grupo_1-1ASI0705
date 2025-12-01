import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Tienda } from '../models/tienda';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';

const base_url=environment.base;
@Injectable({
  providedIn: 'root',
})

export class Tiendaservice {
  private url=`${base_url}/tienda`;
  private listacamTiend=new Subject<Tienda[]>();
  constructor(private http:HttpClient) {}

  list(){
    return this.http.get<Tienda[]>(`${this.url}/listarTienda`);
  }

  insert(ti:Tienda){
    return this.http.post(`${this.url}/registrarTienda`,ti);
  }

  setList(listanuev:Tienda[]){
    this.listacamTiend.next(listanuev);
  }
  
  getList(){
    return this.listacamTiend.asObservable();
  }

  listId(id:number){
    return this.http.get<Tienda>(`${this.url}/${id}`);
  }

  update(ti:Tienda){
    return this.http.put(`${this.url}/editar`,ti,{responseType:'text'});
  }

  delete(id:number){
    return this.http.delete(`${this.url}/${id}`,{responseType:'text'});
  }

  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<Tienda[]>(`${this.url}/busquedas`, { params });
  }
}
