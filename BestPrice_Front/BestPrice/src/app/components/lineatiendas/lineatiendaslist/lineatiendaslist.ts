import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { LineatiendaService } from '../../../services/lineatiendaservice';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { LineatiendaList } from '../../../models/lineatiendalist';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-lineatiendaslist',
  imports: [MatTableModule,CommonModule,MatButtonModule,MatIconModule, RouterLink, MatInputModule, MatToolbarModule, MatMenuModule, MatPaginatorModule, ReactiveFormsModule],
  templateUrl: './lineatiendaslist.html',
  styleUrl: './lineatiendaslist.css',
})
export class Lineatiendaslist implements OnInit {

  dataSource: MatTableDataSource<LineatiendaList> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7'];

  nombrebusqueda: string = '';
  mensaje: string = '';
  form: FormGroup;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private ltS: LineatiendaService,
    private fb: FormBuilder,
    private snackBar: MatSnackBar,
    private loginService: Loginservice
  ) {
    this.form = this.fb.group({
      nombrebusqueda: [''],
    });
  }

ngOnInit(): void {

  this.ltS.getList().subscribe((data) => {
    this.dataSource = new MatTableDataSource(data);
  });

  this.ltS.list().subscribe((data) => {
    this.ltS.setList(data);
  });
}


  eliminar(id:number){
    this.ltS.delete(id).subscribe(data=>{
      this.ltS.list().subscribe(data=>{
        this.ltS.setList(data)
        this.showSnackBar('Distrito eliminado con éxito');
      })
    })
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
