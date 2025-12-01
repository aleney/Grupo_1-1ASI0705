import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Loginservice } from '../../services/loginservice';

@Component({
  selector: 'app-menu',
  imports: [
    MatIconModule,
    MatToolbarModule,
    MatMenuModule,
    MatButtonModule,
    RouterLink,
    MatInputModule,
    MatCardModule,
    FormsModule,
    CommonModule,
  ],
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu {
  searchText: string = '';

  cards = [
    { title: 'Producto', route: '/producto', img: 'assets/images/Menu_Productos.png'},
    { title: 'Tipo de Tienda', route: '/tipotienda', img: 'assets/images/Menu_TipoTienda.png'},
    { title: 'Tienda', route: '/tienda', img: 'assets/images/Menu_Tiendas.png'},
    { title: 'Linea de Tienda', route: '/lineatiendas', img: 'assets/images/Menu_LineaTienda.png'},
    { title: 'Distrito', route: '/distrito', img: 'assets/images/Menu_Distrito.png'},
    { title: 'Historial de Precio', route: '/historialprecio', img: 'assets/images/Menu_HistorialPrecio.png'},
    { title: 'Ofertas de Productos', route: '/ofertasproducto', img: 'assets/images/Menu_Ofertas.png'},
    { title: 'Ubicacion de Tiendas', route: '/lineatienda', img: 'assets/images/Menu_UbiTienda.png'},
    { title: 'Usuario', route: '/usuario/insert', img: '/assets/images/Usuarioinsert.jpeg'},
    { title: 'Rol', route: '/rol', img: '/assets/images/Rolinsert.png'},
    { title: 'Ticket Reporte', route: '/ticketreporte', img: '/assets/images/Reporteinsert.png'},
    { title: 'Ticket Respuesta', route: '/ticketrespuesta', img: '/assets/images/Respuestainsert.png'},
  ];

  get filteredCards() {
    if (!this.searchText.trim()) return this.cards;
    return this.cards.filter((c) => c.title.toLowerCase().includes(this.searchText.toLowerCase()));
  }

  settingsOpen: boolean = false;

  toggleSettings() {
    this.settingsOpen = !this.settingsOpen;

    if (!this.settingsOpen) {
      setTimeout(() => {
        window.scrollTo(0, 0)
      }, 0);
    }
  }

  role: string = '';
  usuario: string = '';

  constructor(private loginService: Loginservice) {
    this.role = this.loginService.showRole();
  }

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
