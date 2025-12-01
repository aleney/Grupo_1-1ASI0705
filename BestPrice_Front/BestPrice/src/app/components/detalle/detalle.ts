import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Detalleinsert } from './detalleinsert/detalleinsert';

@Component({
  selector: 'app-detalle',
  imports: [Detalleinsert, RouterOutlet, CommonModule],
  templateUrl: './detalle.html',
  styleUrl: './detalle.css',
})
export class Detalle {
  constructor(public route:ActivatedRoute){}

}
