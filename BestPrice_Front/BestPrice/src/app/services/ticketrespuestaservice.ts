import { Injectable } from "@angular/core";
import { environment } from '../../environments/environment';
import { TicketRespuesta } from "../models/ticketrespuesta";
import { Subject } from "rxjs";
import { HttpClient } from "@angular/common/http";

const base_url = environment.base

@Injectable({
    providedIn: 'root'
})
export class TicketRespuestaService{

  private url = `${base_url}/roles`;
  private listaTRes = new Subject<TicketRespuesta[]>();

  constructor(private http: HttpClient) {}

  list() {
    return this.http.get<TicketRespuesta[]>(this.url);
  }

  insert(ticketrespuesta: TicketRespuesta) {
    return this.http.post(this.url, ticketrespuesta);
  }

  update(ticketrespuesta: TicketRespuesta) {
    return this.http.put(this.url, ticketrespuesta, { responseType: 'text' });
  }

  delete(id: number) {
    return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
  }

  listId(id: number) {
    return this.http.get<TicketRespuesta>(`${this.url}/${id}`);
  }

  setList(listaNueva: TicketRespuesta[]) {
    this.listaTRes.next(listaNueva);
  }

  getList() {
    return this.listaTRes.asObservable();
  }
}