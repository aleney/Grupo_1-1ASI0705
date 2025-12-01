import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { TipoTienda } from '../models/tipotienda';

const base_url=environment.base;
@Injectable({
  providedIn: 'root',
})

export class Tipotiendaservice {
  private url=`${base_url}/tipo-tienda`;
  private listacamTiend=new Subject<TipoTienda[]>();
  constructor(private http:HttpClient) {}

  list(){
    return this.http.get<TipoTienda[]>(`${this.url}/listar`);
  }
  insert(tt:TipoTienda){
    return this.http.post(`${this.url}/insertar`,tt);
  }
  setList(listanuev:TipoTienda[]){
    this.listacamTiend.next(listanuev);
  }
  getList(){
    return this.listacamTiend.asObservable();
  }

  listId(id:number){
    return this.http.get<TipoTienda>(`${this.url}/${id}`);
  }

  update(tt:TipoTienda){
    return this.http.put(`${this.url}/editar`,tt,{responseType:'text'});
  }

  delete(id:number){
    return this.http.delete(`${this.url}/${id}`,{responseType:'text'});
  }

  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<TipoTienda[]>(`${this.url}/busquedas`, { params });
  }
}
