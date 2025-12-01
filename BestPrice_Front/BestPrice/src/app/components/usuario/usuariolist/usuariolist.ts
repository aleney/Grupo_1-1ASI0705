import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { UsuarioService } from '../../../services/usuarioservice';
import { UsuarioList } from '../../../models/usuariolist';
import { MatMenuModule } from "@angular/material/menu";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatPaginator } from "@angular/material/paginator";
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-usuariolist',
  standalone: true,
  imports: [
    MatTableModule,
    CommonModule,
    RouterLink,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatToolbarModule,
    ReactiveFormsModule,
    MatPaginator,
],
  templateUrl: './usuariolist.html',
  styleUrls: ['./usuariolist.css'],
})
export class Usuariolist implements OnInit {
  dataSource: MatTableDataSource<UsuarioList> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7', 'c8', 'c9'];

  nombrebusqueda: string = '';
  mensaje: string = '';
  form: FormGroup;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private uS: UsuarioService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
  ) {
    this.form = this.fb.group({
      nombrebusqueda: [''],
    });
  }

  ngOnInit(): void {
    // Cargar lista inicial
    this.uS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });

    this.uS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });

    // BUSCADOR conectado al backend
    this.form.get('nombrebusqueda')?.valueChanges.subscribe((value) => {
      if (value && value.trim() !== '') {
        this.searchByName(value);
      } else {
        // Si está vacío, recargar lista completa
        this.uS.list().subscribe((data) => {
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.paginator = this.paginator;
        });
      }
    });
  }

  // Nuevo método que usa el servicio
  searchByName(nombre: string) {
    this.uS.searchName(nombre).subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  eliminar(id: number) {
    this.uS.delete(id).subscribe(() => {
      this.uS.list().subscribe((data) => {
        this.uS.setList(data);
        this.showSnackBar('Usuario eliminado con éxito');
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

  cerrar() {
    sessionStorage.clear();
  }
}