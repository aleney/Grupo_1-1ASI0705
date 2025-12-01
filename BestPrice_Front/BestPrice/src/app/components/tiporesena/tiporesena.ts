import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Tiporesenalistar } from './tiporesenalistar/tiporesenalistar';

@Component({
  selector: 'app-tiporesena',
  imports: [Tiporesenalistar, RouterOutlet],
  templateUrl: './tiporesena.html',
  styleUrl: './tiporesena.css',
})
export class Tiporesena {
  constructor(public route:ActivatedRoute){}

}
