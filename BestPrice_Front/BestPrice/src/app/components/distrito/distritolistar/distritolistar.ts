import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';

import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule, MatLabel } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Loginservice } from '../../../services/loginservice';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DistritoService } from '../../../services/distritoservice';
import { DistritoListModel } from '../../../models/distritolist';
import { GoogleMap } from '@angular/google-maps';

@Component({
  selector: 'app-distritolistar',
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
    MatMenuModule,
    MatToolbarModule,
    GoogleMap
  ],
  templateUrl: './distritolistar.html',
  styleUrl: './distritolistar.css',
})
export class Distritolistar implements OnInit {

  center: google.maps.LatLngLiteral = {lat: -12.0464, lng: -77.0428};
  zoom = 12;

  dataSource: MatTableDataSource<DistritoListModel> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7', 'c8'];
  nombrebusqueda: string = '';
  mensaje: string = '';
  form: FormGroup;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private dS: DistritoService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private loginService: Loginservice
  ) {
    this.form = this.fb.group({
      nombrebusqueda: [''],
    });
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.dS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });

    this.form.get('nombrebusqueda')?.valueChanges.subscribe((value) => {
      this.nombrebusqueda = value;
      this.buscar();
    });

    this.dS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  eliminar(id: number) {
    this.dS.delete(id).subscribe(() => {
      this.dS.list().subscribe((data) => {
        this.dS.setList(data);
        this.showSnackBar('Distrito eliminado con éxito');
      });
    });
  }

  buscar() {
    const termino = this.nombrebusqueda.trim();

    if (termino === '') {
      // Si el campo está vacío → listar todos los registros
      this.dS.list().subscribe((data) => {
        this.dataSource = new MatTableDataSource(data);
      });
      return;
    }

    // Si hay texto → buscar coincidencias
    this.dS.searchName(termino).subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.mensaje = data.length === 0 ? 'No se encontraron registros.' : '';
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

  isSeller() {
    return this.role === 'SELLER';
  }

  isClient() {
    return this.role === 'CLIENT';
  }
}