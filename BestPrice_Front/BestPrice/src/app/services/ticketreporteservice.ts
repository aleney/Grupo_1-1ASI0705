import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { Subject } from "rxjs";
import { TicketReporte } from "../models/ticketreporte";
import { HttpClient } from "@angular/common/http";

const base_url = environment.base

@Injectable({
    providedIn: 'root'
})
export class TicketReporteService{

  private url = `${base_url}/roles`;
  private listaTRep = new Subject<TicketReporte[]>();

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<TicketReporte[]>(this.url);
  }

  insert(ticketreporte: TicketReporte) {
    return this.http.post(this.url, ticketreporte);
  }

  update(ticketreporte: TicketReporte) {
    return this.http.put(this.url, ticketreporte, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  listId(id: number) {
    return this.http.get<TicketReporte>(`${this.url}/${id}`);
  }

  setList(listaNueva: TicketReporte[]) {
    this.listaTRep.next(listaNueva);
  }

  getList() {
    return this.listaTRep.asObservable();
  }
}