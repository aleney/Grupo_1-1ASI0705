import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';
import { Loginservice } from '../../../services/loginservice';
import { Historialprecio } from '../../../models/historialprecio';
import { Historialprecioservice } from '../../../services/historialprecioservice';

@Component({
  selector: 'app-historialpreciolistar',
  imports: [
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    MatTableModule,
    MatButtonModule,
    MatPaginator,
    MatSnackBarModule,
    RouterLink,
  ],
  templateUrl: './historialpreciolistar.html',
  styleUrl: './historialpreciolistar.css',
})
export class Historialpreciolistar implements OnInit {
  dataSource: MatTableDataSource<Historialprecio> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3'];

  constructor(
    private hpS: Historialprecioservice,
    private snackBar: MatSnackBar,
    private loginService: Loginservice
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.hpS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    this.hpS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
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
