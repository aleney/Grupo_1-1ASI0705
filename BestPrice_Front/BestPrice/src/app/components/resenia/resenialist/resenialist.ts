import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';
import { ReseniaService } from '../../../services/reseniaservice';
import { ReseniaList } from '../../../models/resenialist';

@Component({
  selector: 'app-resenialist',
  imports: [MatTableModule,CommonModule,MatButtonModule,MatIconModule, RouterLink, MatToolbarModule, MatMenuModule],
  templateUrl: './resenialist.html',
  styleUrl: './resenialist.css',
})
export class Resenialist implements OnInit {

  dataSource: MatTableDataSource<ReseniaList> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7', 'c8'];

  constructor(private rS: ReseniaService) {}

  ngOnInit(): void {
    this.rS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    this.rS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id:number){
    this.rS.delete(id).subscribe(data=>{
      this.rS.list().subscribe(data=>{
        this.rS.setList(data)
      })
    })
  }
}
