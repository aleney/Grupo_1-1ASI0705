import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { LineatiendaService } from '../../../services/lineatiendaservice';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { LineatiendaList } from '../../../models/lineatiendalist';

@Component({
  selector: 'app-lineatiendaslist',
  imports: [MatTableModule,CommonModule,MatButtonModule,MatIconModule, RouterLink, MatToolbarModule, MatMenuModule],
  templateUrl: './lineatiendaslist.html',
  styleUrl: './lineatiendaslist.css',
})
export class Lineatiendaslist implements OnInit {

  dataSource: MatTableDataSource<LineatiendaList> = new MatTableDataSource();
  displayedColumns: string[] = ['c1', 'c2', 'c3', 'c4', 'c5', 'c6', 'c7'];

  constructor(private ltS: LineatiendaService) {}

  ngOnInit(): void {
    this.ltS.list().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
    this.ltS.getList().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }

  eliminar(id:number){
    this.ltS.delete(id).subscribe(data=>{
      this.ltS.list().subscribe(data=>{
        this.ltS.setList(data)
      })
    })
  }
}
