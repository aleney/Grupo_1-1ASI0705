import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { Canasta } from '../../../models/canasta';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CommonModule } from '@angular/common';
import { CanastaService } from '../../../services/canastaservice';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-canastainsert',
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
  templateUrl: './canastainsert.html',
  styleUrl: './canastainsert.css',
})
export class Canastainsert {
  form: FormGroup = new FormGroup({});
  canasta: Canasta = new Canasta();
  id: number = 0;
  edicion: boolean = false;

  constructor(
    private cS: CanastaService,
    private router: Router,
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private loginService: Loginservice
  ) {
    this.role = this.loginService.showRole();
  }
  ngOnInit(): void {
    this.form = this.fb.group({
      idCanasta: [''],
      nombreCanasta: ['', [Validators.required, Validators.minLength(3)]],
      usuarioCanasta: ['', [Validators.required]],
    });

    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.canasta = this.form.value;

    if (this.edicion) {
      this.cS.update(this.canasta).subscribe({
        next: () => {
          this.cS.list().subscribe((data) => {
            this.cS.setList(data);
          });
          this.router.navigate(['/canasta']);
        },
      });
    } else {
      this.cS.insert(this.canasta).subscribe({
        next: () => {
          this.cS.list().subscribe((data) => {
            this.cS.setList(data);
          });
          this.router.navigate(['/canasta']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.cS.listId(this.id).subscribe({
        next: (data) => {
          this.form = new FormGroup({
            idCanasta: new FormControl(data.idCanasta),
            nombreCanasta: new FormControl(data.nombreCanasta),
            usuarioCanasta: new FormControl(data.usuarioCanasta),
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
