import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-menu',
  imports: [MatIconModule,MatToolbarModule,MatMenuModule,MatButtonModule,RouterLink, MatInputModule, MatCardModule],
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu {

}
