import { Component, OnInit, ViewChild} from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule} from '@angular/material/input';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Tipotiendaservice } from '../../../services/tipotiendaservice';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatMenuModule } from '@angular/material/menu';
import { Loginservice } from '../../../services/loginservice';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TipoTienda } from '../../../models/tipotienda';
import { MatIconModule } from '@angular/material/icon';



@Component({
  selector: 'app-tipotiendalistar',
  imports: [    MatTableModule,
    CommonModule,
    RouterLink,
    MatButtonModule,
    MatIconModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    MatInputModule,
    MatMenuModule,
    MatToolbarModule,
   
  ],
  templateUrl: './tipotiendalistar.html',
  styleUrl: './tipotiendalistar.css',
})
export class Tipotiendalistar implements OnInit {
  dataSource: MatTableDataSource<TipoTienda> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;


  constructor(
    private tlS: Tipotiendaservice,
    private snackBar:MatSnackBar,
    private loginService: Loginservice,
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.tlS.list().subscribe((data)=>{
      this.dataSource = new MatTableDataSource(data);
    });
    this.tlS.getList().subscribe((data)=>{
      this.dataSource = new MatTableDataSource(data);
    });
  }
  
  eliminar(id: number) {
    this.tlS.delete(id).subscribe((data)=>{
      this.tlS.list().subscribe((data)=>{
        this.tlS.setList(data)
        this.showSnackBar('Tipo de tienda eliminada con éxito');
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
