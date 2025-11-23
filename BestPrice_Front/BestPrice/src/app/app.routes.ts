import { Routes } from '@angular/router';
import { Lineatiendas } from './components/lineatiendas/lineatiendas';
import { Menu } from './components/menu/menu';
import { Resenia } from './components/resenia/resenia';
import { Lineatiendasinsert } from './components/lineatiendas/lineatiendasinsert/lineatiendasinsert';
import { Reseniainsert } from './components/resenia/reseniainsert/reseniainsert';
import { Resenialist } from './components/resenia/resenialist/resenialist';
import { Lineatiendaslist } from './components/lineatiendas/lineatiendaslist/lineatiendaslist';

export const routes: Routes = [
    
    { path: '', redirectTo: 'menu', pathMatch: 'full' },
    
    { path: 'menu', component: Menu },

    //{ path: 'productos', component: ProductosComponent },

    { path: 'lineatienda', component: Lineatiendas, 
      children:[
        { path: 'lineatiendalist', component: Lineatiendaslist},
        { path: 'lineatiendainsert', component: Lineatiendasinsert}
      ]
    },

    { path: 'resenia', component: Resenia, 
      children:[
        { path: 'reseniainsert', component: Reseniainsert},
        { path: 'resenialist', component: Resenialist }
      ]
    }

];
