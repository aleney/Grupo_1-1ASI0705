import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Rol } from '../../../models/rol';
import { RolService } from '../../../services/rolservice';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { CommonModule } from '@angular/common';
import { Loginservice } from '../../../services/loginservice';

@Component({
  selector: 'app-rolinsert',
  imports: [
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    RouterLink,
    MatIconModule,
    MatMenuModule,
    MatDatepickerModule,
    MatNativeDateModule,
    CommonModule,
  ],
  templateUrl: './rolinsert.html',
  styleUrl: './rolinsert.css',
})
export class RolInsert {
  form: FormGroup = new FormGroup({});
  rol: Rol = new Rol();
  id: number = 0;
  edicion: boolean = false;

  constructor(
    private rolservice: RolService,
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
      idRol: [''],
      tipoUsuario: ['', Validators.required],
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.rol = this.form.value;

    if (this.edicion) {
      this.rolservice.update(this.rol).subscribe({
        next: () => {
          this.rolservice.list().subscribe((data) => {
            this.rolservice.setList(data);
          });
          this.router.navigate(['/rol']);
        },
      });
    } else {
      this.rolservice.insert(this.rol).subscribe({
        next: () => {
          this.rolservice.list().subscribe((data) => {
            this.rolservice.setList(data);
          });
          this.router.navigate(['/rol']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.rolservice.listId(this.id).subscribe({
        next: (data) => {
          this.form = new FormGroup({
            idRol: new FormControl(data.idRol),
            tipoUsuario: new FormControl(data.tipoUsuario),
          });
        },
      });
    }
  }

  role: string = '';
  usuarioNombre: string = '';

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