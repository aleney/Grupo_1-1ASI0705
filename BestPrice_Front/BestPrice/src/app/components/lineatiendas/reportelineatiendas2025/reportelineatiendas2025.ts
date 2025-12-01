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
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-reportelineatiendas2025',
  imports: [MatTableModule, MatIconModule, RouterLink, MatMenuModule, MatToolbarModule, CommonModule, MatButtonModule, ReactiveFormsModule, MatPaginatorModule],
  templateUrl: './reportelineatiendas2025.html',
  styleUrl: './reportelineatiendas2025.css',
})
export class Reportelineatiendas2025 implements OnInit {

  constructor(
    private ltS:LineatiendaService,
    private loginService: Loginservice
  ) {}

  dataSource: MatTableDataSource<Lineatiendaanio2025> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5'];

  ngOnInit(): void {
    this.ltS.getTiendasAnioactual().subscribe(data => {
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

  isSeller() {
    return this.role === 'SELLER';
  }

  isClient() {
    return this.role === 'CLIENT';
  }

}
