import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { Historialprecio } from '../models/historialprecio';

const base_url=environment.base;
@Injectable({
  providedIn: 'root',
})

export class Historialprecioservice {
  private url=`${base_url}/historial-precio`;
  private listaCamb=new Subject<Historialprecio[]>();
  constructor(private http:HttpClient) {}

  list(){
    return this.http.get<Historialprecio[]>(`${this.url}/listarTienda`);
  }
  insert(tt:Historialprecio){
    return this.http.post(`${this.url}/listar`,tt);
  }
  setList(listanuev:Historialprecio[]){
    this.listaCamb.next(listanuev);
  }

  getList(){
    return this.listaCamb.asObservable();
  }

  listId(id:number){
    return this.http.get<Historialprecio>(`${this.url}/${id}`);
  }

  update(tt:Historialprecio){
    return this.http.put(`${this.url}/editar`,tt,{responseType:'text'});
  }

  delete(id:number){
    return this.http.delete(`${this.url}/${id}`,{responseType:'text'});
  }

  searchName(nombre: string) {
    const params = {n: nombre};
    return this.http.get<Historialprecio[]>(`${this.url}/busquedas`, { params });
  }
}
