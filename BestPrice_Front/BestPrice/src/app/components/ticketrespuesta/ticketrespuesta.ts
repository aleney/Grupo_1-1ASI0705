import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { TicketRespuestaInsert } from './ticketrespuestainsert/ticketrespuestainsert';

@Component({
  selector: 'app-ticketrespuesta',
  imports: [RouterOutlet, TicketRespuestaInsert],
  templateUrl: './ticketrespuesta.html',
  styleUrl: './ticketrespuesta.css',
})
export class Ticketrespuesta {
 constructor(public route:ActivatedRoute){}
}
