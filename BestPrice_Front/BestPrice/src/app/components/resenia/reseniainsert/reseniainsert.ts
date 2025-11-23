import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Resenia } from '../../../models/resenia';
import { ReseniaService } from '../../../services/reseniaservice';
import { MatRadioButton, MatRadioModule } from '@angular/material/radio';
import { MatOption } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-reseniainsert',
  imports: [ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    RouterLink,
    MatIconModule,
    MatMenuModule,
    MatRadioModule,
    MatSelectModule],
  templateUrl: './reseniainsert.html',
  styleUrl: './reseniainsert.css',
})
export class Reseniainsert implements OnInit{
  form: FormGroup = new FormGroup({});
  r: Resenia = new Resenia();
  id: number = 0;
  today = new Date();
  edicion: boolean = false;

  exactitudPrecio: boolean = true;

  calificaciones: { value: number; viewValue: string }[] = [
    { value: 1, viewValue: '1 Estrella' },
    { value: 2, viewValue: '2 Estrellas' },
    { value: 3, viewValue: '3 Estrellas' },
    { value: 4, viewValue: '4 Estrellas' },
    { value: 5, viewValue: '5 Estrellas' },
  ];

  constructor(
  private rS: ReseniaService,
  private router: Router,
  private formBuilder: FormBuilder,
  private route: ActivatedRoute
) { }

ngOnInit(): void {
  this.route.params.subscribe((data: Params) => {
    this.id = data['id'];
    this.edicion = data['id'] != null;
    this.init();
  });

  this.form = this.formBuilder.group({
      id: [''],
      calificacion: ['', Validators.required],
      detalle: ['', Validators.required],
      exactitudPrecio: [false, Validators.required]
    });
}

registrar(): void {
  if (this.form.valid) {
    this.r.idResena = this.form.value.id;
    this.r.calificacionResena = this.form.value.calificacion;
    this.r.detalleResena = this.form.value.detalle;
    this.r.exactitudPrecioResena = this.form.value.exactitudPrecio;
    if (this.edicion) {
      this.rS.update(this.r).subscribe(() =>{
        this.rS.list().subscribe((data) => {
          this.rS.setList(data);
        })
      })
    } else {
      this.rS.insert(this.r).subscribe(() =>{
        this.rS.list().subscribe((data) => {
          this.rS.setList(data);
    })
  })
  }
  this.router.navigate(['resenia'])
}


}
init() {
  if (this.edicion) {
    this.rS.listId(this.id).subscribe((data) => {
      this.form = new FormGroup({
        id: new FormControl(data.idResena),
        nombre: new FormControl(data.calificacionResena),
        detalle: new FormControl(data.detalleResena),
        date: new FormControl(data.exactitudPrecioResena)
      });
    });
  }
}

}
