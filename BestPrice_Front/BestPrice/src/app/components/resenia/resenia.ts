import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Resenialist } from "./resenialist/resenialist";

@Component({
  selector: 'app-resenia',
  imports: [RouterOutlet, Resenialist],
  templateUrl: './resenia.html',
  styleUrl: './resenia.css',
})
export class Resenia {
    constructor(public route:ActivatedRoute){}
}
