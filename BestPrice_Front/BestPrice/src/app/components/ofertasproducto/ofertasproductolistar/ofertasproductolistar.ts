import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild, viewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink, RouterModule } from '@angular/router';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatMenu } from '@angular/material/menu';
import { MatToolbar } from '@angular/material/toolbar';
import { MatMenuTrigger } from '@angular/material/menu';
import { MatSnackBar } from '@angular/material/snack-bar';

import { Router } from '@angular/router';
import { Ofertasproductoservice } from '../../../services/ofertasproductoservice';
@Component({
  selector: 'app-ofertasproductolistar',
  imports: [
    MatTableModule,
    CommonModule,
    RouterLink,
    MatButtonModule,
    RouterModule,
    MatIconModule,
    MatPaginator,
    MatPaginatorModule,
    MatMenu,
    MatToolbar,
    MatMenuTrigger,
  ],
  templateUrl: './ofertasproductolistar.html',
  styleUrl: './ofertasproductolistar.css',
})

export class Ofertasproductolistar implements OnInit {
  dataSource: MatTableDataSource<any> = new MatTableDataSource();
  displayedColumns: string[] = ['codigo', 'fechainicio', 'fechafin', 'idproducto', 'actions'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private opS: Ofertasproductoservice,
    private snackBar: MatSnackBar,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.opS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    this.opS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    this.opS.delete(id).subscribe((data) => {
      this.opS.list().subscribe((data) => {
        this.opS.setList(data);
        this.showSnackBar('Oferta de producto eliminado con éxito');
      });
    });
  }

  showSnackBar(message: string) {
    this.snackBar.open(message, 'Cerrar', {
      duration: 3000,
      horizontalPosition: 'right',
      verticalPosition: 'top',
    });
  }
}
