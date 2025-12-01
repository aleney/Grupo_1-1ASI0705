import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Historialpreciolistar } from './historialpreciolistar/historialpreciolistar';

@Component({
  selector: 'app-historialprecio',
  imports: [Historialpreciolistar, RouterOutlet],
  templateUrl: './historialprecio.html',
  styleUrl: './historialprecio.css',
})

export class Historialprecio {
  constructor(public route: ActivatedRoute) {}
}
