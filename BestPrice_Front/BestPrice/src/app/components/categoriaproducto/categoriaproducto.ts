import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Categoriaproductoinsert } from './categoriaproductoinsert/categoriaproductoinsert';

@Component({
  selector: 'app-categoriaproducto',
  imports: [RouterOutlet, Categoriaproductoinsert],
  templateUrl: './categoriaproducto.html',
  styleUrl: './categoriaproducto.css',
})
export class Categoriaproducto {
  constructor(public route:ActivatedRoute){}
}
