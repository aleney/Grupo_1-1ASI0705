import { Component } from '@angular/core';
import { Form, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatFormField, MatLabel, MatInputModule } from "@angular/material/input";
import { MatRadioGroup, MatRadioButton } from "@angular/material/radio";
import { TipoResena } from '../../../models/tiporesena';
import { TipoResenaservice } from '../../../services/tiporesenaservice';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Loginservice } from '../../../services/loginservice';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tiporesenainsert',
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
    CommonModule, MatRadioButton],
  templateUrl: './tiporesenainsert.html',
  styleUrl: './tiporesenainsert.css',
})
export class Tiporesenainsert {

  form:FormGroup=new FormGroup({});
  tiporesena:TipoResena=new TipoResena();
  id:number=0;
  edicion:boolean=false;

  constructor(
    private trS:TipoResenaservice,
    private router:Router,
    private fb:FormBuilder,
    private route:ActivatedRoute, 
    private loginService:Loginservice,

  ) { 
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.form = this.fb.group({
      idTipoResena: [''],
      nombreTipoResena: ['', [Validators.required]],
      descripcionTipoResena: ['', [Validators.required]],
    });

    this.route.params.subscribe((data:Params)=>{
      this.id=data['id'];
      this.edicion=data['id'] != null;
      this.init();
    });
  }

  registrar():void{
    if(!this.form.valid) return;  
      this.tiporesena=this.form.value;

      if(this.edicion){
        this.trS.update(this.tiporesena).subscribe({
          next:()=>{
          this.trS.list().subscribe((data)=>{
            this.trS.setList(data);
            });
            this.router.navigate(['tiporesena/listar']);
          },
          });
      }else{
        this.trS.insert(this.tiporesena).subscribe({
          next:()=>{
            this.trS.list().subscribe((data)=>{
              this.trS.setList(data);
            });
            this.router.navigate(['tiporesena']);
          },
        });
      }
    }
      init(){
        if(this.edicion){
          this.trS.listId(this.id).subscribe({
            next:(data) =>{
              this.form=new FormGroup({
                idTipoResena:new FormControl(data.idTipoResena),
                nombreTipoResena:new FormControl(data.nombreTipoResena),
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
      

