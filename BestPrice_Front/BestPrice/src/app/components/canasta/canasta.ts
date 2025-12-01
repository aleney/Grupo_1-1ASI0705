import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Canastalistar } from "./canastalistar/canastalistar";
import { RouterLink } from '@angular/router';
import { Canastainsert } from "./canastainsert/canastainsert";
@Component({
  selector: 'app-canasta',
  imports: [RouterOutlet, CommonModule, Canastainsert],
  templateUrl: './canasta.html',
  styleUrl: './canasta.css',
})
export class Canasta {
  constructor(public route:ActivatedRoute){}

}

