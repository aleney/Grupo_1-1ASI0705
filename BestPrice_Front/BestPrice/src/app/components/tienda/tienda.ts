import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Tiendainsert } from "./tiendainsert/tiendainsert";

@Component({
  selector: 'app-tienda',
  imports: [Tiendainsert, RouterOutlet, ],
  templateUrl: './tienda.html',
  styleUrl: './tienda.css',
})
export class Tienda {
  constructor(public route:ActivatedRoute){}
}
