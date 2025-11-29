import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Lineatiendaslist } from './lineatiendaslist/lineatiendaslist';

@Component({
  selector: 'app-lineatiendas',
  imports: [RouterOutlet, Lineatiendaslist],
  templateUrl: './lineatiendas.html',
  styleUrl: './lineatiendas.css',
})

export class Lineatiendas {
  constructor(public route:ActivatedRoute){}
}
