import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Productoservice } from '../../../services/productoservice';

import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CommonModule } from '@angular/common';
import { Loginservice } from '../../../services/loginservice';
import { MatRadioModule } from '@angular/material/radio';
import { CategoriaProducto } from '../../../models/categoriaproducto';
import { Categoriaproductoservice } from '../../../services/categoriaproductoservice';
import { MatSelectModule } from '@angular/material/select';
import { Tienda } from '../../../models/tienda';
import { Tiendaservice } from '../../../services/tiendaservice';
import { ProductoInsert } from '../../../models/productoinsert';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

@Component({
  selector: 'app-productoinsert',
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
    MatRadioModule,
    MatSelectModule,
    MatSlideToggleModule
  ],
  templateUrl: './productoinsert.html',
  styleUrl: './productoinsert.css',
})
export class Productoinsert {
  form: FormGroup = new FormGroup({});
  producto: ProductoInsert = new ProductoInsert();
  id: number = 0;
  edicion: boolean = false;
  estado: boolean = true;
  listaCatProducto: CategoriaProducto[] = [];
  listaTienda: Tienda[] = [];

  constructor(
    private ps: Productoservice,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loginService: Loginservice,
    private cpS: Categoriaproductoservice,
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
    this.cpS.list().subscribe((data) => {
      this.listaCatProducto = data;
    });

    this.tS.list().subscribe((data) => {
      this.listaTienda = data;
    });

    this.form = this.fb.group({
      idProducto: [''],
      nombreProducto: ['', [Validators.required, Validators.minLength(3)]],
      descripcionProducto: ['', [Validators.required, Validators.maxLength(450)]],
      marcaProducto: ['', Validators.required],
      precioProducto: ['', [Validators.required, Validators.min(0)]],
      stockProducto: ['', [Validators.required, Validators.min(0)]],
      unidadMetricaProducto: ['', [Validators.required, Validators.min(0)]],
      favoritoProducto: ['', Validators.required],
      disponibleProducto: ['', Validators.required],
      tienda: ['', Validators.required],
      categoriaProducto: ['', Validators.required]
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.producto = this.form.value;

    if (this.edicion) {
      this.ps.update(this.producto).subscribe({
        next: () => {
          this.ps.list().subscribe((data) => {
            this.ps.setList(data);
          });
          this.router.navigate(['/producto']);
        },
      });
    } else {
      this.ps.insert(this.producto).subscribe({
        next: () => {
          this.ps.list().subscribe((data) => {
            this.ps.setList(data);
          });
          this.router.navigate(['/producto']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.ps.listId(this.id).subscribe({
        next: (data) => {
          this.form = new FormGroup({
            idProducto: new FormControl(data.idProducto),
            nombreProducto: new FormControl(data.nombreProducto),
            descripcionProducto: new FormControl(data.descripcionProducto),
            marcaProducto: new FormControl(data.marcaProducto),
            precioProducto: new FormControl(data.precioProducto),
            stockProducto: new FormControl(data.stockProducto),
            unidadMetricaProducto: new FormControl(data.unidadMetricaProducto),
            favoritoProducto: new FormControl(data.favoritoProducto),
            disponibleProducto: new FormControl(data.disponibleProducto),
            categoriaproducto: new FormControl(data.categoriaProducto.idCategoriaProducto),
            tienda: new FormControl(data.tienda.idTienda)
          });
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
