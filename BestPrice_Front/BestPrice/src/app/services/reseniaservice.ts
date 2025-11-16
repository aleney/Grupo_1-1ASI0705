import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Subject } from 'rxjs';
import { environment } from '../environments/environment';
import { Resenia } from '../components/resenia/resenia';
const base_url = environment.base;

@Injectable({
  providedIn: 'root'
})
export class ReseniaService {
  private url = `${base_url}/resenias`;
  private listaResenia = new Subject<Resenia[]>();
  constructor(private http: HttpClient) {}
  
}
