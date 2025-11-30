import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbar } from '@angular/material/toolbar';
import { MatIcon } from '@angular/material/icon';
import { MatMenu, MatMenuTrigger } from '@angular/material/menu';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { Detalle } from '../../../models/detalle';
import { RouterLink } from '@angular/router';
import { DetalleService } from '../../../services/detalleservice';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-detallelistar',
  imports: [
    MatToolbar,
    MatIcon,
    MatMenu,
    MatTableModule,
    CommonModule,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    MatSnackBarModule,
    MatMenuTrigger,
    RouterLink,
  ],
  templateUrl: './detallelistar.html',
  styleUrl: './detallelistar.css',
})
export class Detallelistar {
  dataSource: MatTableDataSource<Detalle> = new MatTableDataSource();
  displayedColumns: string[] = ['cantidad', 'producto', 'canasta', 'actions'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(
    private dS: DetalleService,
    private snackBar: MatSnackBar,
    private loginService: Loginservice
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.dS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
    this.dS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }
  eliminar(id: number) {
    this.dS.delete(id).subscribe((data) => {
      this.dS.list().subscribe((data) => {
        this.dS.setList(data);
        this.showSnackBar('Detalle de la canasta eliminada con éxito');
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

  role: string = '';
  usuario: string = '';

  cerrar() {
    sessionStorage.clear();
  }

  verificar() {
    this.role = this.loginService.showRole();
    return this.loginService.verificar();
  }

  isAdmin() {
    return this.role === 'ADMIN';
  }

  isClient() {
    return this.role === 'CLIENT';
  }

  isSeller() {
    return this.role === 'SELLER';
  }
}
