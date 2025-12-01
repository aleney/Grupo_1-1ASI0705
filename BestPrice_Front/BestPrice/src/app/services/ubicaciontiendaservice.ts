import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { TipoTienda } from '../models/tipotienda';
import { Ubicaciontienda } from '../models/ubicaciontienda';

const base_url=environment.base;
@Injectable({
  providedIn: 'root',
})

export class Ubicaciontiendaservice {
  private url=`${base_url}/ubicacion-tienda`;
  private listacamUbiTiend=new Subject<Ubicaciontienda[]>();
  constructor(private http:HttpClient) {}

  list(){
    return this.http.get<Ubicaciontienda[]>(`${this.url}/listar`);
  }
  insert(tt:Ubicaciontienda){
    return this.http.post(`${this.url}/insertar`,tt);
  }
  setList(listanuev:Ubicaciontienda[]){
    this.listacamUbiTiend.next(listanuev);
  }
  getList(){
    return this.listacamUbiTiend.asObservable();
  }

  listId(id:number){
    return this.http.get<Ubicaciontienda>(`${this.url}/listar${id}`);
  }

  update(tt:Ubicaciontienda){
    return this.http.put(`${this.url}/editar`,tt,{responseType:'text'});
  }

  delete(id:number){
    return this.http.delete(`${this.url}/${id}`,{responseType:'text'});
  }

  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<Ubicaciontienda[]>(`${this.url}/busquedas`, { params });
  }
}
