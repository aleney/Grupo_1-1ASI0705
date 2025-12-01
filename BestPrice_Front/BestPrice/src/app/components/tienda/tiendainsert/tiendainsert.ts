import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule, provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { Tienda } from '../../../models/tienda';
import { Tiendaservice } from '../../../services/tiendaservice';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Productoservice } from '../../../services/productoservice';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Loginservice } from '../../../services/loginservice';
import { CommonModule } from '@angular/common';
import { ProductoInsert } from '../../../models/productoinsert';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { Tipotiendaservice } from '../../../services/tipotiendaservice';
import { LineatiendaService } from '../../../services/lineatiendaservice';
import { TipoTienda } from '../../../models/tipotienda';
import { LineatiendaInsert } from '../../../models/lineatiendainsert';

@Component({
  selector: 'app-tiendainsert',
  imports: [
    MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatRadioModule,
    CommonModule,
    MatMenuModule,
    MatIconModule,
    MatToolbarModule,
    RouterLink,
    MatSlideToggleModule,
  ],
  templateUrl: './tiendainsert.html',
  providers: [provideNativeDateAdapter()],
  styleUrl: './tiendainsert.css',
})
export class Tiendainsert implements OnInit {
  form: FormGroup = new FormGroup({});
  Tiend: Tienda = new Tienda();
  id: number = 0;
  today = new Date();
  listaTT: TipoTienda[] = [];
  listaLT: LineatiendaInsert[] = [];

  TiposT: { value: string; viewValue: string }[] = [
    { value: 'Abarrotes', viewValue: 'Abarrotes' },
    { value: 'Ropa', viewValue: 'Ropa' },
    { value: 'Electronica', viewValue: 'Electronica' },
    { value: 'Juguetes', viewValue: 'Juguetes' },
    { value: 'Bazar', viewValue: 'Bazar' },
    { value: 'Botica', viewValue: 'Botica' },
  ];

  edicion: boolean = false;
  estado: boolean = true;

  constructor(
    private T: Tiendaservice,
    private router: Router,
    private formbuilder: FormBuilder,
    private route: ActivatedRoute,
    private sP: Productoservice,
    private sTT: Tipotiendaservice,
    private lT: LineatiendaService,
    private loginService: Loginservice
  ) {
    this.role = this.loginService.showRole();
  }

  ngOnInit(): void {
    this.route.params.subscribe((data) => {
      this.id = data['id'];
      this.edicion = data['id'] != null;
      this.init();
    });

    this.sTT.list().subscribe((data) => {
      this.listaTT = data;
    });

    this.lT.list().subscribe((data) => {
      this.listaLT = data;
    });

    this.form = this.formbuilder.group({
      id: [''],
      nombreTienda: ['', Validators.required],
      descripcionTienda: ['', Validators.required],
      numeroTelefono: ['', [Validators.required, Validators.pattern(/^[0-9]{9}$/)]],
      estadoTienda: ['', Validators.required],
      lineaTienda: ['', Validators.required],
      tipoTienda: ['', Validators.required],
    });
  }

  aceptar(): void {
    if (!this.form.valid) return;
      this.Tiend = this.form.value;
    
    if (this.edicion) {
      this.T.update(this.Tiend).subscribe(() => {
        this.T.list().subscribe((data) => {
          this.T.setList(data);
        });
      });
    } else {
      this.T.insert(this.Tiend).subscribe((data) => {
        this.T.list().subscribe((data) => {
          this.T.setList(data);
        });
      });
    }
  }

  init() {
    if (this.edicion) {
      this.T.listId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idTienda),
          nombreTienda: new FormControl(data.nombreTienda),
          descripcionTienda: new FormControl(data.descripcionTienda),
          numeroTelefono: new FormControl(data.numeroTelefono),
          estadoTienda: new FormControl(data.estadoTienda),
          lineaTienda: new FormControl(data.lineaTienda.idLineaTienda),
          tipoTienda: new FormControl(data.tipoTienda.idTipoTienda),
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
