import { Component, ViewChild } from '@angular/core';
import { Ubicaciontienda } from '../../../models/ubicaciontienda';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule, MatLabel } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Ubicaciontiendaservice } from '../../../services/ubicaciontiendaservice';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-ubicaciontiendalistar',
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
  ],
  templateUrl: './ubicaciontiendalistar.html',
  styleUrl: './ubicaciontiendalistar.css',
})
export class Ubicaciontiendalistar {
  dataSource: MatTableDataSource<Ubicaciontienda> = new MatTableDataSource();
  displayedColumns: string[] = ['c1','c2','c3','c4','c5','c6','c7','c8'];
  nombrebusqueda: string = '';
  mensaje: string = '';
  form: FormGroup;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private uS: Ubicaciontiendaservice,
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
    // Cargar lista inicial
    this.uS.list().subscribe((data: Ubicaciontienda[]) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });

    // Búsqueda reactiva
    this.form.get('nombrebusqueda')?.valueChanges.subscribe((value) => {
      this.nombrebusqueda = value;
      this.buscar();
    });

    // Escuchar cambios en lista
    this.uS.getList().subscribe((data: Ubicaciontienda[]) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  eliminar(id: number) {
    this.uS.delete(id).subscribe(() => {
      this.uS.list().subscribe((data) => {
        this.uS.setList(data);
        this.showSnackBar('Ubicación eliminada con éxito');
      });
    });
  }

  buscar() {
    const termino = this.nombrebusqueda.trim();

    if (termino === '') {
      this.uS.list().subscribe((data) => {
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator = this.paginator;
      });
      return;
    }

    this.uS.searchName(termino).subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
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
