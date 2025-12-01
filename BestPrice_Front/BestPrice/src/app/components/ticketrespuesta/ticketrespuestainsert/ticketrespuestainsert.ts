import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { TicketRespuestaService } from '../../../services/ticketrespuestaservice';
import { TicketReporteService } from '../../../services/ticketreporteservice';
import { UsuarioService } from '../../../services/usuarioservice';
import { TicketReporte } from '../../../models/ticketreporte';
import { TicketRespuesta } from '../../../models/ticketrespuesta';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatSelectModule } from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { Loginservice } from '../../../services/loginservice';
import { UsuarioList } from '../../../models/usuariolist';

@Component({
  selector: 'app-ticketrespuestainsert',
  imports: [
    ReactiveFormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatMenuModule,
    MatSelectModule,
    RouterLink,
    CommonModule,
  ],
  templateUrl: './ticketrespuestainsert.html',
  styleUrl: './ticketrespuestainsert.css',
})
export class TicketRespuestaInsert {
  form: FormGroup = new FormGroup({});
  respuesta: TicketRespuesta = new TicketRespuesta();
  tickets: TicketReporte[] = [];
  usuarios: UsuarioList[] = [];
  id: number = 0;
  edicion: boolean = false;

  constructor(
    private fb: FormBuilder,
    private ticketRespuestaService: TicketRespuestaService,
    private ticketReporteService: TicketReporteService,
    private usuarioService: UsuarioService,
    private router: Router,
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
      idRespuesta: [''],
      detalle: ['', Validators.required],
      ticketreporte: [null, Validators.required],
      usuario: [null, Validators.required],
    });

    // Cargar tickets disponibles
    this.ticketReporteService.list().subscribe((data) => {
      this.tickets = data;
    });

    // Cargar usuarios disponibles
    this.usuarioService.list().subscribe((data) => {
      this.usuarios = data;
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.respuesta = this.form.value;

    if (this.edicion) {
      this.ticketRespuestaService.update(this.respuesta).subscribe({
        next: () => {
          this.ticketRespuestaService.list().subscribe((data) => {
            this.ticketRespuestaService.setList(data);
          });
          this.router.navigate(['/ticketrespuesta']);
        },
      });
    } else {
      this.ticketRespuestaService.insert(this.respuesta).subscribe({
        next: () => {
          this.ticketRespuestaService.list().subscribe((data) => {
            this.ticketRespuestaService.setList(data);
          });
          this.router.navigate(['/ticketrespuesta']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.ticketRespuestaService.listId(this.id).subscribe({
        next: (data) => {
          this.form = new FormGroup({
            idRespuesta: new FormControl(data.idTicketRes),
            detalle: new FormControl(data.detalle),
            ticketreporte: new FormControl(data.ticketreporte),
            usuario: new FormControl(data.usuario),
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