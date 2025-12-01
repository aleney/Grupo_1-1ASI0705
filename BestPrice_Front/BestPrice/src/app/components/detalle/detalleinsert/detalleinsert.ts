import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatFormField, MatLabel, MatError } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Detalle } from '../../../models/detalle';
import { DetalleService } from '../../../services/detalleservice';
import { Loginservice } from '../../../services/loginservice';
import { provideNativeDateAdapter } from '@angular/material/core';

@Component({
  selector: 'app-detalleinsert',
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
  templateUrl: './detalleinsert.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './detalleinsert.css',
})
export class Detalleinsert {
  form: FormGroup = new FormGroup({});
  detalle: Detalle = new Detalle();
  id: number = 0;
  edicion: boolean = false;

  constructor(
    private dS: DetalleService,
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
      idDetalle: [''],
      cantidadCanastaDetalle: ['', [Validators.required, Validators.min(0)]],
      productoCanastaDetalle: ['', [Validators.required]],
      canastaCanastaDetalle: ['', [Validators.required]],
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.detalle = this.form.value;

    if (this.edicion) {
      this.dS.update(this.detalle).subscribe({
        next: () => {
          this.dS.list().subscribe((data) => {
            this.dS.setList(data);
          });
          this.router.navigate(['/detalle']);
        },
      });
    } else {
      this.dS.insert(this.detalle).subscribe({
        next: () => {
          this.dS.list().subscribe((data) => {
            this.dS.setList(data);
          });
          this.router.navigate(['/detalle']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.dS.listId(this.id).subscribe({
        next: (data) => {
          this.form = new FormGroup({
            idDetalle: new FormControl(data.idDetalle),
            cantidadCanastaDetalle: new FormControl(data.cantidadCanastaDetalle),
            productoCanastaDetalle: new FormControl(data.productoCanastaDetalle),
            canastaCanastaDetalle: new FormControl(data.canastaCanastaDetalle),
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
