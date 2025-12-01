import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Ubicaciontiendainsert } from './ubicaciontiendainsert/ubicaciontiendainsert';

@Component({
  selector: 'app-ubicaciontienda',
  imports: [RouterOutlet, Ubicaciontiendainsert],
  templateUrl: './ubicaciontienda.html',
  styleUrl: './ubicaciontienda.css',
})
export class Ubicaciontienda {
  constructor(public route:ActivatedRoute){}
}
