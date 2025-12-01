import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatSnackBar } from '@angular/material/snack-bar';
import { TipoResenaservice } from '../../../services/tiporesenaservice';
import { TipoResena } from '../../../models/tiporesena';
import { MatToolbar, MatToolbarModule } from '@angular/material/toolbar';
import { MatIcon, MatIconModule } from '@angular/material/icon';
import { MatMenu, MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatPaginator } from "@angular/material/paginator";
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-tiporesenalistar',
  templateUrl: './tiporesenalistar.html',
  styleUrls: ['./tiporesenalistar.css'],
  imports: [MatToolbarModule, MatIconModule, MatMenuModule, MatTableModule, MatButtonModule, MatPaginator,RouterLink],
})
export class Tiporesenalistar implements OnInit {

  dataSource: MatTableDataSource<TipoResena> = new MatTableDataSource();
  displayedColumns: string[]=['id','fecha','producto_id','acciones'];

  constructor(private tS: TipoResenaservice){}

  ngOnInit(): void {
    this.tS.list().subscribe((data) =>{
      this.dataSource=new MatTableDataSource(data);
    });
    this.tS.getList().subscribe((data)=>{
      this.dataSource=new MatTableDataSource(data);
    });      
  }

  eliminar(id:number){
    this.tS.delete(id).subscribe(data =>{
      this.tS.list().subscribe(data=>{
        this.tS.setList(data)
      })
    }) 
   }
}
