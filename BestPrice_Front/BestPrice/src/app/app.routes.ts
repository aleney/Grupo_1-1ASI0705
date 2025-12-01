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
import { Reportelineatiendas2025 } from './components/lineatiendas/reportelineatiendas2025/reportelineatiendas2025';
import { Distrito } from './components/distrito/distrito';
import { Distritolistar } from './components/distrito/distritolistar/distritolistar';
import { Distritoinsert } from './components/distrito/distritoinsert/distritoinsert';

export const routes: Routes = [

    { path: '', redirectTo: 'login', pathMatch: 'full' },

    { path: 'login', component: Autenticador },

    { path: 'menu', component: Menu, 
      canActivate: [seguridadGuard]
    },

    //{ path: 'productos', component: ProductosComponent },

    { path: 'lineatienda', component: Lineatiendas, 
      children:[
        { path: 'listar', component: Lineatiendaslist},
        { path: 'edits/:id', component: Lineatiendasinsert},
        { path: 'insertar', component: Lineatiendasinsert},
        { path: 'anioactual', component: Reportelineatiendas2025}
      ],
      canActivate: [seguridadGuard]
    },

    { path: 'resenia', component: Resenia, 
      children:[
        { path: 'insertar', component: Reseniainsert},
        { path: 'edits/:id', component: Reseniainsert},
        { path: 'listar', component: Resenialist }
      ],
      canActivate: [seguridadGuard]
    },

    {
    path: 'distrito',
    component: Distrito,
    children: [
      { path: 'listar', component: Distritolistar },
      { path: 'insertar', component: Distritoinsert },
    ],
    //canActivate: [seguridadGuard],
  },

];
