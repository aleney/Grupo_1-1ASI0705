import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatToolbar } from '@angular/material/toolbar';
import { MatIcon } from '@angular/material/icon';
import { MatMenu } from '@angular/material/menu';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { MatMenuTrigger } from '@angular/material/menu';
import { CategoriaProducto } from '../../../models/categoriaproducto';
import { Categoriaproductoservice } from '../../../services/categoriaproductoservice';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-categoriaproductolistar',
  imports: [
    MatToolbar,
    MatIcon,
    MatMenu,
    MatPaginator,
    MatTableModule,
    CommonModule,
    RouterLink,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    MatSnackBarModule,
    MatMenuTrigger,
  ],
  templateUrl: './categoriaproductolistar.html',
  styleUrls: ['./categoriaproductolistar.css'],
})
export class Categoriaproductolistar implements OnInit {
  displayedColumns: string[] = ['id', 'nombre', 'actions'];
  dataSource: MatTableDataSource<CategoriaProducto> = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(
    private ctS: Categoriaproductoservice,
    private snackBar: MatSnackBar,
    private router: Router,
    private loginService: Loginservice
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.ctS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
    this.ctS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  eliminar(id: number) {
    this.ctS.delete(id).subscribe((data) => {
      this.ctS.list().subscribe((data) => {
        this.ctS.setList(data);
        this.showSnackBar('Categoría de producto eliminado con éxito');
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
