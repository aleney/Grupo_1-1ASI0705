import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Canasta } from '../../../models/canasta';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatToolbar } from '@angular/material/toolbar';
import { MatIcon } from '@angular/material/icon';
import { MatMenu, MatMenuTrigger } from '@angular/material/menu';
import { CanastaService } from '../../../services/canastaservice';
import { Loginservice } from '../../../services/loginservice';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-canastalistar',
  imports: [
    MatToolbar,
    MatIcon,
    MatMenu,
    MatTableModule,
    CommonModule,
    RouterLink,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    MatSnackBarModule,
    MatMenuTrigger,
  ],
  templateUrl: './canastalistar.html',
  styleUrl: './canastalistar.css',
})
export class Canastalistar implements OnInit {
  dataSource: MatTableDataSource<Canasta> = new MatTableDataSource();
  displayedColumns: string[] = ['codigo', 'creado', 'actualizado', 'registradoPor','actualizar','eliminar'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  nombrebusqueda: string = '';
  mensaje: string = '';
  form: FormGroup;

  constructor(
    private cS: CanastaService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private router: Router,
    private loginService: Loginservice
  ) {
   this.form = this.fb.group({
      nombrebusqueda: [''],
    });
  }

  ngOnInit(): void {
    this.cS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
    this.cS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });

      // BUSCADOR
    this.form.get('nombrebusqueda')?.valueChanges.subscribe((value) => {
      this.applyFilter(value);
    });
  }

  applyFilter(value: string) {
  value = value.trim().toLowerCase();
  this.dataSource.filter = value;
}

  eliminar(id: number) {
    this.cS.delete(id).subscribe((data) => {
      this.cS.list().subscribe((data) => {
        this.cS.setList(data);
        this.showSnackBar('Canasta eliminada con éxito');
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
