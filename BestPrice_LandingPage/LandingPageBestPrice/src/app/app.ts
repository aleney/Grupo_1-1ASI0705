import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Footer } from './component/footer/footer';
import { Navbar } from './component/navbar/navbar';
import { Inicio } from "./component/inicio/inicio";
import { Use } from "./component/use/use";
import { AboutUs } from "./component/about-us/about-us";
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { Testimonios } from "./component/testimonios/testimonios";

@Component({
  selector: 'app-root',
  imports: [Navbar, Footer, Inicio, Use, AboutUs, MatToolbarModule, MatButtonModule, MatIconModule, MatCardModule, Testimonios],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('LandingPageBestPrice');
}
