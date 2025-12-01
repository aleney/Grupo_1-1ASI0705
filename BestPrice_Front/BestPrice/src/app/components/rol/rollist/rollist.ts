import { Component, OnInit, ViewChild } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatPaginator } from '@angular/material/paginator';
import { RolService } from '../../../services/rolservice';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { Rol } from '../../../models/rol';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { CommonModule, DatePipe } from '@angular/common';
import { MatMenuModule } from '@angular/material/menu';

@Component({
  selector: 'app-rollist',
  imports: [
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    DatePipe,
    RouterLink,
    MatTableModule,
    CommonModule,
    MatMenuModule,
    MatPaginator
],
  templateUrl: './rollist.html',
  styleUrl: './rollist.css'
})
export class RolList implements OnInit{
  dataSource:MatTableDataSource<Rol> = new MatTableDataSource();
  displayedColumns:string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6'];
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private rS: RolService) {}

  ngOnInit(): void {
   
    this.rS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
    this.rS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  eliminar(id: number) {
    this.rS.delete(id).subscribe((data) => {
      this.rS.list().subscribe((data) => {
        this.rS.setList(data);
      });
    });
  }

  cerrar() {
    sessionStorage.clear();
  }


}
