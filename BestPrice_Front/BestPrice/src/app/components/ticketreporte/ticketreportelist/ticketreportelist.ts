import { Component, OnInit, ViewChild } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import { MatMenuModule } from '@angular/material/menu';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { TicketReporteService } from '../../../services/ticketreporteservice';
import { TicketReporte } from '../../../models/ticketreporte';

@Component({
  selector: 'app-ticketreportelist',
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
    MatSlideToggleModule,
    MatPaginator
],
  templateUrl: './ticketreportelist.html',
  styleUrl: './ticketreportelist.css'
})
export class TicketReporteList implements OnInit {
  dataSource: MatTableDataSource<TicketReporte> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private tS: TicketReporteService) {}

  ngOnInit(): void {
    this.tS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
    this.tS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  eliminar(id: number) {
    this.tS.delete(id).subscribe(() => {
      this.tS.list().subscribe((data) => {
        this.tS.setList(data);
      });
    });
  }

  cerrar() {
    sessionStorage.clear();
  }
}