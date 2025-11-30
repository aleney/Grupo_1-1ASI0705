import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatIcon } from "@angular/material/icon";
import { MatTableModule } from '@angular/material/table';
import { MatMenu } from "@angular/material/menu";
import { MatToolbar } from "@angular/material/toolbar";
import { MatFormField, MatError, MatLabel } from "@angular/material/input";
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CommonModule } from '@angular/common';
import { MatRadioModule } from '@angular/material/radio';
import { Ofertasproducto } from '../../../models/ofertasproducto';
import { Ofertasproductoservice } from '../../../services/ofertasproductoservice';


@Component({
  selector: 'app-ofertasproductoinsert',
  imports: [ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    RouterLink,
    MatIconModule,
    MatMenuModule,
    MatInputModule,
    MatDatepickerModule,
    CommonModule,
    MatRadioModule,
    MatTableModule,  
  ],
  templateUrl: './ofertasproductoinsert.html',
  styleUrl: './ofertasproductoinsert.css',
})
export class Ofertasproductoinsert {
  form: FormGroup = new FormGroup({});
  ofertasproducto: Ofertasproducto=new Ofertasproducto();
  id: number = 0;
  edicion: boolean = false;
  estado: boolean = true;

  constructor(
    private ops: Ofertasproductoservice,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });
  
    this.form = this.fb.group({
      idOfertasproducto: [''],
      fechainicio: ['',[Validators.required]],
      fechafin: ['',[Validators.required]],
    });
  }
  
  registrar():void{
    if (!this.form.valid) return;

    this.ofertasproducto=this.form.value;
    
    if(this.edicion){
      this.ops.update(this.ofertasproducto).subscribe({
        next:()=>{
          this.ops.list().subscribe((data)=>{
            this.ops.setList(data);
          });
          this.router.navigate(['/ofertasproducto/listar']);
        },
      });
  }else {
      this.ops.insert(this.ofertasproducto).subscribe({
        next:()=>{
          this.ops.list().subscribe((data)=>{
            this.ops.setList(data);
          });
          this.router.navigate(['/ofertasproducto/listar']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.ops.listId(this.id).subscribe({
      next:(data)=>{
        this.form = new FormGroup({
          idOfertasproducto: new FormControl(data.idOfertasproducto),
          fechainicio: new FormControl(data.fechainicio),
          fechafin: new FormControl(data.fechafin),
        });
      }
    });
  }
}
  role: string = '';
  usuario: string = '';

  cerrar() {
    sessionStorage.clear();
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

  isTester() {
    return this.role === 'TESTER';
  }

}
