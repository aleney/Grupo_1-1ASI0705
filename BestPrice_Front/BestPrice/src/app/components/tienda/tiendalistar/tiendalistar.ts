import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Tiendaservice } from '../../../services/tiendaservice';
import { Tienda } from '../../../models/tienda';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule, MatLabel } from '@angular/material/input';
import { Loginservice } from '../../../services/loginservice';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';

@Component({
  selector: 'app-tiendalistar',
  imports: [
    MatTableModule,
    CommonModule,
    RouterLink,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatInputModule,
    MatLabel,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule
  ],
  templateUrl: './tiendalistar.html',
  styleUrl: './tiendalistar.css',
})
export class Tiendalistar implements OnInit {
  dataSource: MatTableDataSource<Tienda> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7', 'c8', 'c9'];
  nombrebusqueda: string = '';
  mensaje: string = '';
  form: FormGroup;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private sT: Tiendaservice,
    private fb: FormBuilder,
    private loginService: Loginservice
  ) {
    this.form = this.fb.group({
      nombrebusqueda: [''],
    });
    this.role = this.loginService.showRole();
  }
  ngOnInit(): void {
    this.sT.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });

    this.form.get('nombrebusqueda')?.valueChanges.subscribe((value) => {
      this.nombrebusqueda = value;
      this.buscar();
    });

    this.sT.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    this.sT.delete(id).subscribe((data) => {
      this.sT.list().subscribe((data) => {
        this.sT.setList(data);
      });
    });
  }

  buscar() {
    const termino = this.nombrebusqueda.trim();

    if (termino === '') {
      // Si el campo está vacío → listar todos los registros
      this.sT.list().subscribe((data) => {
        this.dataSource = new MatTableDataSource(data);
      });
      return;
    }

    // Si hay texto → buscar coincidencias
    this.sT.searchName(termino).subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.mensaje = data.length === 0 ? 'No se encontraron registros.' : '';
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

  isTester() {
    return this.role === 'TESTER';
  }
}
