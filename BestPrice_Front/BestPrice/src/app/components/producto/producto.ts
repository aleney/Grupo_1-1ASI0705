import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Productoinsert } from "./productoinsert/productoinsert";

@Component({
  selector: 'app-producto',
  imports: [Productoinsert, RouterOutlet],
  templateUrl: './producto.html',
  styleUrl: './producto.css',
})
export class Producto {
  [x: string]: any;

  constructor(public route:ActivatedRoute){}
}
