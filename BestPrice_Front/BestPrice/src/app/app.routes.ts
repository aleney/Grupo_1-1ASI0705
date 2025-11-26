import { Routes } from '@angular/router';
import { Lineatiendas } from './components/lineatiendas/lineatiendas';
import { Menu } from './components/menu/menu';
import { Resenia } from './components/resenia/resenia';
import { Lineatiendasinsert } from './components/lineatiendas/lineatiendasinsert/lineatiendasinsert';
import { Reseniainsert } from './components/resenia/reseniainsert/reseniainsert';
import { Resenialist } from './components/resenia/resenialist/resenialist';
import { Lineatiendaslist } from './components/lineatiendas/lineatiendaslist/lineatiendaslist';
import { seguridadGuard } from './guard/security-guard';
import { Autenticador } from './components/autenticador/autenticador';

export const routes: Routes = [

    { path: '', redirectTo: 'login', pathMatch: 'full' },

    { path: 'login', component: Autenticador },

    { path: 'menu', component: Menu, 
      canActivate: [seguridadGuard]
    },

    //{ path: 'productos', component: ProductosComponent },

    { path: 'lineatienda', component: Lineatiendas, 
      children:[
        { path: 'lineatiendalist', component: Lineatiendaslist},
        { path: 'edits/:id', component: Lineatiendasinsert},
        { path: 'lineatiendainsert', component: Lineatiendasinsert}
      ],
      canActivate: [seguridadGuard]
    },

    { path: 'resenia', component: Resenia, 
      children:[
        { path: 'reseniainsert', component: Reseniainsert},
        { path: 'edits/:id', component: Reseniainsert},
        { path: 'resenialist', component: Resenialist }
      ],
      canActivate: [seguridadGuard]
    }

];
