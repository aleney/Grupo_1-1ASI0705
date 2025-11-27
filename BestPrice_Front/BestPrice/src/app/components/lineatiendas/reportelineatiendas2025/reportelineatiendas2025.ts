import { Component, OnInit } from '@angular/core';
import { LineatiendaService } from '../../../services/lineatiendaservice';
import { Lineatiendaanio2025 } from '../../../models/lineatiendaanio2025';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-reportelineatiendas2025',
  imports: [MatTableModule, MatIconModule, RouterLink, MatMenuModule, MatToolbarModule, CommonModule, MatButtonModule],
  templateUrl: './reportelineatiendas2025.html',
  styleUrl: './reportelineatiendas2025.css',
})
export class Reportelineatiendas2025 implements OnInit {

  constructor(private ltS:LineatiendaService ) {}

  dataSource: MatTableDataSource<Lineatiendaanio2025> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5'];

  ngOnInit(): void {
    this.ltS.getTiendasAnioactual().subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
    });

  }

}
