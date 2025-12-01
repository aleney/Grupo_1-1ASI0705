import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Historialprecioinsert } from "./historialprecioinsert/historialprecioinsert";

@Component({
  selector: 'app-historialprecio',
  imports: [Historialprecioinsert, RouterOutlet],
  templateUrl: './historialprecio.html',
  styleUrl: './historialprecio.css',
})
export class Historialprecio {
  constructor(public route:ActivatedRoute){}
}
