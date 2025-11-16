import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';

interface Testimonio {
  nombre: string;
  texto: string;
  rating: number;
}

@Component({
  selector: 'app-testimonios',
  imports: [MatToolbarModule, MatButtonModule, MatIconModule, MatCardModule],
  templateUrl: './testimonios.html',
  styleUrl: './testimonios.css',
})
export class Testimonios {
  testimonios: Testimonio[] = [
    {
      nombre: 'Franco Jara',
      texto: '¡BestPrice ha cambiado mi forma de comprar en línea! Ahora puedo comparar precios fácilmente y ver la evolución de los precios en un solo lugar. ¡Una herramienta increíble para ahorrar dinero!',
      rating: 5
    },
    {
      nombre: 'Amardina Fernandez',
      texto: 'La navegación en la página web de BestPrice es intuitiva y fácil de usar. No puedo creer lo conveniente que es para comparar precios en diferentes tiendas. ¡Altamente recomendado!',
      rating: 5
    },
    {
      nombre: 'Erick Landeo',
      texto: 'Nunca volveré a comprar sin consultar BestPrice primero. Me encanta cómo esta plataforma simplifica la búsqueda de las mejores ofertas y ahorra tiempo y dinero.',
      rating: 5
    }
  ];

  currentIndex = 1;

  nextTestimonio() {
    this.currentIndex = (this.currentIndex + 1) % this.testimonios.length;
  }

  prevTestimonio() {
    this.currentIndex =
      (this.currentIndex - 1 + this.testimonios.length) %
      this.testimonios.length;
  }
}
