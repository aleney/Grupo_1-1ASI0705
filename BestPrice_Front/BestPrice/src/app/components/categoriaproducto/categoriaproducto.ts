import { Component } from '@angular/core';
import { Categoriaproductoinsert } from './categoriaproductoinsert/categoriaproductoinsert';
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-categoriaproducto',
  imports: [RouterOutlet,],
  templateUrl: './categoriaproducto.html',
  styleUrl: './categoriaproducto.css',
})
export class Categoriaproducto {
  constructor(public route:ActivatedRoute){}
}
