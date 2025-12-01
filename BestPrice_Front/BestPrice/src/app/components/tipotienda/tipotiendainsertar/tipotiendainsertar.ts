import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Loginservice } from '../../../services/loginservice';
import { Tipotiendaservice } from '../../../services/tipotiendaservice';
import { TipoTienda } from '../../../models/tipotienda';
import { provideNativeDateAdapter } from '@angular/material/core';

@Component({
  selector: 'app-tipotiendainsertar',
  imports: [ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    RouterLink,
    MatIconModule,
    MatMenuModule,],
  templateUrl: './tipotiendainsertar.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './tipotiendainsertar.css',
})
export class Tipotiendainsertar implements OnInit{
  form: FormGroup = new FormGroup({});
  tT: TipoTienda = new TipoTienda();
  id: number = 0;
  today = new Date();
  edicion: boolean = false;

  constructor(
    private tTS: Tipotiendaservice,
    private router: Router,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private loginService: Loginservice
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

    this.form = this.formBuilder.group({
      id: [''],
      nombre: ['', Validators.required],
      detalle: ['', Validators.required],
    });
  }

  registrar(): void {
    if (this.form.valid) {
      this.tT.idTipoTienda = this.form.value.id;
      this.tT.nombreTipoTienda = this.form.value.nombre;
      if (this.edicion) {
        this.tTS.update(this.tT).subscribe(() => {
          this.tTS.list().subscribe((data) => {
            //this.tTS.setList(data);
          });
        });
      } else {
        this.tTS.insert(this.tT).subscribe(() => {
          this.tTS.list().subscribe((data) => {
           // this.tTS.setList(data);
          });
        });
      }
      this.router.navigate(['tipotienda/listar']);
    }
  }

  init() {
    if (this.edicion) {
      this.tTS.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idTipoTienda),
          nombre: new FormControl(data.nombreTipoTienda),
        });
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

  isTester() {
    return this.role === 'TESTER';
  }
}
