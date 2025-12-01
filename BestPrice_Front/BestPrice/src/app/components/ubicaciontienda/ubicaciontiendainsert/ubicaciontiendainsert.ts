import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Ubicaciontienda } from '../../../models/ubicaciontienda';
import { Ubicaciontiendaservice } from '../../../services/ubicaciontiendaservice';
import { Loginservice } from '../../../services/loginservice';
import { DistritoService } from '../../../services/distritoservice';
import { Tiendaservice } from '../../../services/tiendaservice';
import { Tienda } from '../../../models/tienda';
import { Distrito } from '../../../models/distrito';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-ubicaciontiendainsert',
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
    CommonModule, MatSelectModule
  ],
  templateUrl: './ubicaciontiendainsert.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './ubicaciontiendainsert.css',
})
export class Ubicaciontiendainsert {
  form: FormGroup = new FormGroup({});
  uT: Ubicaciontienda = new Ubicaciontienda();
  id: number = 0;
  edicion: boolean = false;
  today: Date = new Date();
  listaDistrito: Distrito[] = [];
  listaTiendaa: Tienda[] = [];

  constructor(
    private ds: Ubicaciontiendaservice,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loginService: Loginservice,
    private dS: DistritoService,
    private tS: Tiendaservice
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

    this.dS.list().subscribe((data) => {
      this.listaDistrito = data;
    });

    this.tS.list().subscribe((data) => {
      this.listaTiendaa = data;
    });

    this.form = this.fb.group({
      id: [''],
      direccion: ['', [Validators.required, Validators.minLength(3)]],
      detalle: ['', [Validators.required, Validators.maxLength(450)]],
      longitud: ['', [Validators.required, Validators.pattern(/^-?[0-9]+(\.[0-9]+)?$/)]],
      latitud: ['', [Validators.required, Validators.pattern(/^-?[0-9]+(\.[0-9]+)?$/)]],
      distrito: ['', Validators.required],
      tiendaa: ['', Validators.required]
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.uT = this.form.value;

    if (this.edicion) {
      this.ds.update(this.uT).subscribe(() => {
        this.ds.list().subscribe((data) => {
          this.ds.setList(data);
        });
      });
      this.router.navigate(['/distrito/listar']);
    } else {
      this.ds.insert(this.uT).subscribe(() => {
        this.ds.list().subscribe((data) => {
          this.ds.setList(data);
        });
        this.router.navigate(['/distrito/listar']);
      });
    }
  }

  init() {
    if (this.edicion) {
      this.ds.listId(this.id).subscribe({
        next: (data) => {
          const fecha = data.createdUT ? new Date(data.createdUT) : new Date();
          this.form = new FormGroup({
            id: new FormControl(data.idUbiTienda),
            direccion: new FormControl(data.direccionUbiTienda),
            detalle: new FormControl(data.detalleLineaTienda),
            longitud: new FormControl(data.longitudUbiTienda),
            latitud: new FormControl(data.latitudUbiTienda),
            distrito: new FormControl(data.distrito.idDistrito),
            tiendaa: new FormControl(data.tiendaa.idTienda),
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
