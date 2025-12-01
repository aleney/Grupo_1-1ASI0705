import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { TipoResena } from '../../../models/tiporesena';
import { MatToolbar, MatToolbarModule } from '@angular/material/toolbar';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatMenu, MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginator } from '@angular/material/paginator';
import { RouterLink } from '@angular/router';
import { TipoResenaservice } from '../../../services/tiporesenaservice';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-tiporesenalistar',
  templateUrl: './tiporesenalistar.html',
  styleUrls: ['./tiporesenalistar.css'],
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
})
export class Tiporesenalistar implements OnInit {
  dataSource: MatTableDataSource<TipoResena> = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'fecha', 'producto_id', 'acciones'];

  constructor(
    private tS: TipoResenaservice,
    private snackBar: MatSnackBar,
    private loginService: Loginservice
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.tS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    this.tS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id: number) {
    this.tS.delete(id).subscribe((data) => {
      this.tS.list().subscribe((data) => {
        this.tS.setList(data);
        this.showSnackBar('Tipo de resenia eliminada con éxito');
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
