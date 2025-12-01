import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { UsuarioService } from '../../../services/usuarioservice';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { CommonModule } from '@angular/common';
import { Loginservice } from '../../../services/loginservice';
import { Usuarioinsert } from '../../../models/usuarioinsert';

@Component({
  selector: 'app-usuarioinsert',
  imports: [
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    RouterLink,
    MatIconModule,
    MatMenuModule,
    MatSlideToggleModule,
    CommonModule,
  ],
  templateUrl: './usuarioinsert.html',
  styleUrl: './usuarioinsert.css',
})
export class UsuarioInsert {
  form: FormGroup = new FormGroup({});
  usuario: Usuarioinsert = new Usuarioinsert();
  id: number = 0;
  edicion: boolean = false;

  constructor(
    private usuarioService: UsuarioService,
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
      idUsuario: [''],
      nombre: ['', [Validators.required]],
      password: ['', [Validators.required]],
      numeroTelefono: ['', [Validators.required]],
      estado: [false],
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.usuario = this.form.value;

    if (this.edicion) {
      this.usuarioService.update(this.usuario).subscribe({
        next: () => {
          this.usuarioService.list().subscribe((data) => {
            this.usuarioService.setList(data);
          });
          this.router.navigate(['/usuario']);
        },
      });
    } else {
      this.usuarioService.insert(this.usuario).subscribe({
        next: () => {
          this.usuarioService.list().subscribe((data) => {
            this.usuarioService.setList(data);
          });
          this.router.navigate(['/usuario']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.usuarioService.listIdInsert(this.id).subscribe({
        next: (data) => {
          this.form = new FormGroup({
            idUsuario: new FormControl(data.idUsuario),
            nombre: new FormControl(data.nombre),
            password: new FormControl(data.password),
            numeroTelefono: new FormControl(data.numeroTelefono),
            estado: new FormControl(data.estado),
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