import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { TicketReporteService } from '../../../services/ticketreporteservice';
import { UsuarioService } from '../../../services/usuarioservice';
import { TicketReporte } from '../../../models/ticketreporte';
import { ActivatedRoute, Params, Router, RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatSelectModule } from '@angular/material/select';
import { CommonModule } from '@angular/common';
import { Loginservice } from '../../../services/loginservice';
import { UsuarioList } from '../../../models/usuariolist';

@Component({
  selector: 'app-ticketreporteinsert',
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
    MatSelectModule,
    CommonModule,
  ],
  templateUrl: './ticketreporteinsert.html',
  styleUrl: './ticketreporteinsert.css',
})
export class TicketReporteInsert {
  form: FormGroup = new FormGroup({});
  ticket: TicketReporte = new TicketReporte();
  usuarios: UsuarioList[] = [];
  id: number = 0;
  edicion: boolean = false;

  constructor(
    private ticketService: TicketReporteService,
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
      idTicketRep: [''],
      detalle: ['', Validators.required],
      ticketStatus: [false],
      usuario: [null, Validators.required],
    });

    // cargar usuarios para el select
    this.usuarioService.list().subscribe((data) => {
      this.usuarios = data;
    });
  }

  registrar(): void {
    if (!this.form.valid) return;

    this.ticket = this.form.value;

    if (this.edicion) {
      this.ticketService.update(this.ticket).subscribe({
        next: () => {
          this.ticketService.list().subscribe((data) => {
            this.ticketService.setList(data);
          });
          this.router.navigate(['/ticketreporte']);
        },
      });
    } else {
      this.ticketService.insert(this.ticket).subscribe({
        next: () => {
          this.ticketService.list().subscribe((data) => {
            this.ticketService.setList(data);
          });
          this.router.navigate(['/ticketreporte']);
        },
      });
    }
  }

  init() {
    if (this.edicion) {
      this.ticketService.listId(this.id).subscribe({
        next: (data) => {
          this.form = new FormGroup({
            idTicketRep: new FormControl(data.idTicketRep),
            detalle: new FormControl(data.detalle),
            ticketStatus: new FormControl(data.ticketStatus),
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