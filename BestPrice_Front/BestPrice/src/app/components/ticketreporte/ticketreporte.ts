import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { TicketReporteInsert } from './ticketreporteinsert/ticketreporteinsert';

@Component({
  selector: 'app-ticketreporte',
  standalone: true,
  imports: [RouterOutlet, TicketReporteInsert],
  templateUrl: './ticketreporte.html',
  styleUrl: './ticketreporte.css',
})
export class Ticketreporte {
  constructor(public route:ActivatedRoute){}
}
