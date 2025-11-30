import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Distritoinsert } from "./distritoinsert/distritoinsert";

@Component({
  selector: 'app-distrito',
  imports: [Distritoinsert, RouterOutlet],
  templateUrl: './distrito.html',
  styleUrl: './distrito.css',
})
export class Distrito {
  constructor(public route:ActivatedRoute){}
}