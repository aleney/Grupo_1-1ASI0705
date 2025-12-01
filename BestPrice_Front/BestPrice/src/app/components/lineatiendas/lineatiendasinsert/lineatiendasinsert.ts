import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { LineatiendaService } from '../../../services/lineatiendaservice';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { Loginservice } from '../../../services/loginservice';
import { Lineatienda } from '../../../models/lineatienda';

@Component({
  selector: 'app-lineatiendasinsert',
  imports: [
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    RouterLink,
    MatIconModule,
    MatMenuModule,
  ],
  templateUrl: './lineatiendasinsert.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './lineatiendasinsert.css',
})
export class Lineatiendasinsert implements OnInit {
  form: FormGroup = new FormGroup({});
  lt: Lineatienda = new Lineatienda();
  id: number = 0;
  today = new Date();
  edicion: boolean = false;

  constructor(
    private ltS: LineatiendaService,
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
      this.lt.idLineaTienda = this.form.value.id;
      this.lt.nombreLineaTienda = this.form.value.nombre;
      this.lt.detalleLineaTienda = this.form.value.detalle;
      if (this.edicion) {
        this.ltS.update(this.lt).subscribe(() => {
          this.ltS.list().subscribe((data) => {
            this.ltS.setList(data);
          });
        });
      } else {
        this.ltS.insert(this.lt).subscribe(() => {
          this.ltS.list().subscribe((data) => {
            this.ltS.setList(data);
          });
        });
      }
      this.router.navigate(['lineatienda/lineatiendalist']);
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
