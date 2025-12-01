import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Ofertasproductoinsert } from "./ofertasproductoinsert/ofertasproductoinsert";

@Component({
  selector: 'app-ofertasproducto',
  imports: [Ofertasproductoinsert, RouterOutlet],
  templateUrl: './ofertasproducto.html',
  styleUrl: './ofertasproducto.css',
})
export class Ofertasproducto {
  constructor(public route:ActivatedRoute){}
}
