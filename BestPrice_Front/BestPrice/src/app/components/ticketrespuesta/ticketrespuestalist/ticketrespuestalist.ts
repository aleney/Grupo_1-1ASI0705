import { CommonModule, DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { TicketRespuestaService } from '../../../services/ticketrespuestaservice';
import { TicketRespuesta } from '../../../models/ticketrespuesta';
import { MatPaginator } from "@angular/material/paginator";

@Component({
  selector: 'app-ticketrespuestalist',
  imports: [
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    DatePipe,
    RouterLink,
    MatTableModule,
    CommonModule,
    MatMenuModule,
    MatPaginator
],
  templateUrl: './ticketrespuestalist.html',
  styleUrl: './ticketrespuestalist.css',
})
export class Ticketrespuestalist implements OnInit{

  dataSource: MatTableDataSource<TicketRespuesta> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6' , 'c7'];

  constructor(private trS:TicketRespuestaService){}

  ngOnInit(): void {
    this.trS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    this.trS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    this.trS.delete(id).subscribe((data) => {
      this.trS.list().subscribe((data) => {
        this.trS.setList(data);
      });
    });
  }

  cerrar() {
    sessionStorage.clear();
  }
}
