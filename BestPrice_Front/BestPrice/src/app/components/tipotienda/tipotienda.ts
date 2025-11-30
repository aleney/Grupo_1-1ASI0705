import { Component } from '@angular/core';
import { Tipotiendainsertar } from "./tipotiendainsertar/tipotiendainsertar";
import { ActivatedRoute, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-tipotienda',
  imports: [Tipotiendainsertar, RouterOutlet],
  templateUrl: './tipotienda.html',
  styleUrl: './tipotienda.css',
})
export class Tipotienda {
  constructor(public route:ActivatedRoute){}
}
