import { Routes } from '@angular/router';
import { Lineatiendas } from './components/lineatiendas/lineatiendas';
import { Menu } from './components/menu/menu';

export const routes: Routes = [
      { path: '', redirectTo: 'menu', pathMatch: 'full' },   // 👈 Aquí forzamos que lo primero sea el menú
    { path: 'menu', component: Menu },
    //{ path: 'productos', component: ProductosComponent },
    { path: 'tienda', component: Lineatiendas }

];
