import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';
import { Ofertasproducto } from '../models/ofertasproducto';
const base_url = environment.base;
@Injectable({
    providedIn: 'root',
})

export class Ofertasproductoservice {
    private url = `${base_url}/ofertasproducto`;
    private listaoferprod = new Subject<Ofertasproducto[]>();
    constructor(private http: HttpClient) { }

    list() {
        return this.http.get<Ofertasproducto[]>(this.url);
    }
    insert(op: Ofertasproducto) {
        return this.http.post(`${this.url}/Registrar`, op);
    }
    setList(listaN: Ofertasproducto[]) {
        this.listaoferprod.next(listaN);
    }
    getList() {
        return this.listaoferprod.asObservable();
    }
    listId(id: number) {
        return this.http.get<Ofertasproducto>(`${this.url}/${id}`);
    }   
    update(op: Ofertasproducto) {
        return this.http.put(`${this.url}`, op, { responseType: 'text' });
    }
    delete(id: number) {
        return this.http.delete(`${this.url}/${id}`, { responseType: 'text' });
    }
}