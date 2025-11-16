import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { Lineatiendas } from '../components/lineatiendas/lineatiendas';
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class LineatiendaService {
  private url = `${base_url}/lineatiendas`;
  private listaLineaTienda = new Subject<Lineatiendas[]>();
  constructor(private http: HttpClient) {}
  
}