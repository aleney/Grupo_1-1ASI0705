import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { LineatiendaService } from '../../../services/lineatiendaservice';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { LineatiendaInsert } from '../../../models/lineatiendainsert';

@Component({
  selector: 'app-lineatiendasinsert',
  imports: [ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    RouterLink,
    MatIconModule,
    MatMenuModule],
  templateUrl: './lineatiendasinsert.html',
  styleUrls: ['./lineatiendasinsert.css'],
})
export class Lineatiendasinsert implements OnInit{
  form: FormGroup = new FormGroup({});
  lt: LineatiendaInsert = new LineatiendaInsert();
  id: number = 0;
  today = new Date();
  edicion: boolean = false;

constructor(
  private ltS: LineatiendaService,
  private router: Router,
  private formBuilder: FormBuilder,
  private route: ActivatedRoute
) { }



ngOnInit(): void {

    this.form = this.formBuilder.group({
      id: [''],
      nombre: ['', Validators.required],
      detalle: ['', Validators.required],
    });

  this.route.params.subscribe((data: Params) => {
    this.id = data['id'];
    this.edicion = data['id'] != null;
    this.init();
  });
  
}

registrar(): void {
  if (this.form.valid) {
    this.lt.idLineaTienda = this.form.value.id;
    this.lt.nombreLineaTienda = this.form.value.nombre;
    this.lt.detalleLineaTienda = this.form.value.detalle;
    if (this.edicion) {
      this.ltS.update(this.lt).subscribe(() =>{
        this.ltS.list().subscribe((data) => {
          this.ltS.setList(data);
        })
      })
    } else {
      this.ltS.insert(this.lt).subscribe(() =>{
        this.ltS.list().subscribe((data) => {
          this.ltS.setList(data);
    })
  })
  }
  this.router.navigate(['lineatienda/listar']);
}

}

init() {
  if (this.edicion) {
    this.ltS.listId(this.id).subscribe((data) => {
      this.form = new FormGroup({
        id: new FormControl(data.idLineaTienda),
        nombre: new FormControl(data.nombreLineaTienda),
        detalle: new FormControl(data.detalleLineaTienda),
      });
    });
  }
}


}
