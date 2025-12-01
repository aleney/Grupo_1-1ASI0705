import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { DistritoService } from '../../../services/distritoservice';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CommonModule } from '@angular/common';
import { Loginservice } from '../../../services/loginservice';
import { DistritoInsertModel } from '../../../models/distritoinsert';

@Component({
  selector: 'app-distritoinsert',
  imports: [
    ReactiveFormsModule,
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
  ],
  templateUrl: './distritoinsert.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './distritoinsert.css',
})
export class Distritoinsert implements OnInit {
  form: FormGroup = new FormGroup({});
  distrito: DistritoInsertModel = new DistritoInsertModel();
  id: number = 0;
  edicion: boolean = false;
  today: Date = new Date();

  constructor(
    private ds: DistritoService,
    private router: Router,
    private fb: FormBuilder,
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

    this.form = this.fb.group({
      id: [''],
      nombre: ['', [Validators.required, Validators.minLength(3)]],
      descripcion: ['', [Validators.required, Validators.maxLength(450)]],
      longitud: ['', [Validators.required, Validators.pattern(/^-?[0-9]+(\.[0-9]+)?$/)]],
      latitud: ['', [Validators.required, Validators.pattern(/^-?[0-9]+(\.[0-9]+)?$/)]],
    });
  }

  registrar(): void {
    if (this.form.valid) {

    this.distrito.idDistrito = this.form.value.id;
    this.distrito.nombreDistrito = this.form.value.nombre;
    this.distrito.descripcionDistrito = this.form.value.descripcion;
    this.distrito.longitudDistrito = parseFloat(this.form.value.longitud);
    this.distrito.latitudDistrito = parseFloat(this.form.value.latitud);
    if (this.edicion) {
      this.ds.update(this.distrito).subscribe(()=>{
          this.ds.list().subscribe((data) => {
            this.ds.setList(data);
          })
      })
    } else {
      this.ds.insert(this.distrito).subscribe(()=>{
          this.ds.list().subscribe((data) => {
            this.ds.setList(data);
          })
      })
    }
    this.router.navigate(['distrito/listar']);
  }

  }

  init() {
    if (this.edicion) {
      this.ds.listId(this.id).subscribe({
        next: (data) => {
          const fecha = data.createdAtDistrito ? new Date(data.createdAtDistrito) : new Date();
          this.form = new FormGroup({
            id: new FormControl(data.idDistrito),
            nombre: new FormControl(data.nombreDistrito),
            descripcion: new FormControl(data.descripcionDistrito),
            longitud: new FormControl(data.longitudDistrito),
            latitud: new FormControl(data.latitudDistrito),
          });
        },
        error: (err) => {
          console.error('Error al cargar distrito:', err);
        },
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