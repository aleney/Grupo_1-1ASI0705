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
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { CategoriaProducto } from '../../../models/categoriaproducto';
import { Categoriaproductoservice } from '../../../services/categoriaproductoservice';
import { Loginservice } from '../../../services/loginservice';
import { provideNativeDateAdapter } from '@angular/material/core';

@Component({
  selector: 'app-categoriaproductoinsert',
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
  templateUrl: './categoriaproductoinsert.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './categoriaproductoinsert.css',
})
export class Categoriaproductoinsert implements OnInit {
  form: FormGroup = new FormGroup({});
  catproducto: CategoriaProducto = new CategoriaProducto();
  id: number = 0;
  edicion: boolean = false;
  today = new Date();

  constructor(
    private cP: Categoriaproductoservice,
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
    });
  }

  registrar(): void {
    if (this.form.valid) {
      this.catproducto.idCategoriaProducto = this.form.value.id;
      this.catproducto.nombreCategoriaProducto = this.form.value.nombre;
      if (this.edicion) {
        this.cP.update(this.catproducto).subscribe(() => {
          this.cP.list().subscribe((data) => {
            this.cP.setList(data);
          });
          this.router.navigate(['/categoriaproducto/listar']);
        });
      } else {
        this.cP.insert(this.catproducto).subscribe(() => {
          this.cP.list().subscribe((data) => {
            this.cP.setList(data);
          });
        });
      }
      this.router.navigate(['/categoriaproducto/listar']);
    }
  }

  init() {
    if (this.edicion) {
      this.cP.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idCategoriaProducto),
          nombre: new FormControl(data.nombreCategoriaProducto),
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
}
