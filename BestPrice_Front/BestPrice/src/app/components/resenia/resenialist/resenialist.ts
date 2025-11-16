import { Component, signal, computed } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-resenialist',
  imports: [MatButtonModule, MatInputModule],
  templateUrl: './resenialist.html',
  styleUrl: './resenialist.css',
})
export class Resenialist {
campo = signal('');

  lista = signal([
    { id: 1, nombre: 'Supermercado' },
    { id: 2, nombre: 'MiniMarket' },
    { id: 3, nombre: 'Bodega' }
  ]);

  filtro = signal('');

  listaFiltrada = computed(() =>
    this.lista().filter(i =>
      i.nombre.toLowerCase().includes(this.filtro().toLowerCase())
    )
  );

  filtrar(event: any) {
    this.filtro.set(event.target.value);
  }

  nuevo() {
    this.campo.set('');
  }

  agregar() {
    if (!this.campo().trim()) return;

    const nuevoId = this.lista().length + 1;

    this.lista.set([
      ...this.lista(),
      { id: nuevoId, nombre: this.campo() }
    ]);

    this.campo.set('');
  }

  eliminar() {
    this.lista.set([]);
  }
}
