import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Lineatiendaslist } from './lineatiendaslist/lineatiendaslist';
import { Lineatiendasinsert } from "./lineatiendasinsert/lineatiendasinsert";


@Component({
  selector: 'app-lineatiendas',
  imports: [RouterOutlet, Lineatiendasinsert],
  templateUrl: './lineatiendas.html',
  styleUrl: './lineatiendas.css',
})

export class Lineatiendas {
  constructor(public route:ActivatedRoute){}
}
