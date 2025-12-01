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
import { Categoriaproducto } from './components/categoriaproducto/categoriaproducto';
import { Categoriaproductolistar } from './components/categoriaproducto/categoriaproductolistar/categoriaproductolistar';
import { Categoriaproductoinsert } from './components/categoriaproducto/categoriaproductoinsert/categoriaproductoinsert';
import { Producto } from './components/producto/producto';
import { Productoinsert } from './components/producto/productoinsert/productoinsert';
import { Productolistar } from './components/producto/productolistar/productolistar';
import { Ofertasproductolistar } from './components/ofertasproducto/ofertasproductolistar/ofertasproductolistar';
import { Ofertasproductoinsert } from './components/ofertasproducto/ofertasproductoinsert/ofertasproductoinsert';
import { Ofertasproducto } from './components/ofertasproducto/ofertasproducto';

import { Tiendalistar } from './components/tienda/tiendalistar/tiendalistar';
import { Tiendainsert } from './components/tienda/tiendainsert/tiendainsert';
import { Tipotiendainsertar } from './components/tipotienda/tipotiendainsertar/tipotiendainsertar';
import { Tiporesenalistar } from './components/tiporesena/tiporesenalistar/tiporesenalistar';
import { Detallelistar } from './components/detalle/detallelistar/detallelistar';


import { Tiporesena } from './components/tiporesena/tiporesena';
import { Canastainsert } from './components/canasta/canastainsert/canastainsert';
import { Canastalistar } from './components/canasta/canastalistar/canastalistar';

import { Ubicaciontienda } from './components/ubicaciontienda/ubicaciontienda';
import { Ubicaciontiendalistar } from './components/ubicaciontienda/ubicaciontiendalistar/ubicaciontiendalistar';
import { Ubicaciontiendainsert } from './components/ubicaciontienda/ubicaciontiendainsert/ubicaciontiendainsert';
import { Historialpreciolistar } from './components/historialprecio/historialpreciolistar/historialpreciolistar';
import { Historialprecio } from './components/historialprecio/historialprecio';
import { Detalleinsert } from './components/detalle/detalleinsert/detalleinsert';
import { Detalle } from './components/detalle/detalle';
import { Tienda } from './components/tienda/tienda';
import { Canasta } from './components/canasta/canasta';

export const routes: Routes = [

    { path: '', redirectTo: 'login', pathMatch: 'full' },

    { path: 'login', component: Autenticador },

    { path: 'menu', component: Menu, 
      canActivate: [seguridadGuard]
    },

    {
    path: 'producto',
    component: Producto,
    children: [
      { path: 'listar', component: Productolistar },
      { path: 'insertar', component: Productoinsert },
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'categoriaproducto',
    component: Categoriaproducto,
    children: [
      { path: 'listar', component: Categoriaproductolistar },
      { path: 'insertar', component: Categoriaproductoinsert },
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'ofertasproducto',
    component: Ofertasproducto,
    children: [
      { path: 'listar', component: Ofertasproductolistar },
      { path: 'insertar', component: Ofertasproductoinsert },
    ],
    //canActivate: [seguridadGuard],
  },

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
    canActivate: [seguridadGuard],
  },

   {
    path: 'tienda',
    component: Tienda,
    children: [
      { path: 'listar', component: Tiendalistar },
      { path: 'insertar', component: Tiendainsert },
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'tipotienda',
    component: Tipotiendainsertar,
    children: [
      { path: 'listar', component: Tiporesenalistar },
      { path: 'insertar', component: Tipotiendainsertar },
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'canasta',
    component: Canasta,
    children: [
      { path: 'listar', component: Canastalistar },
      { path: 'insertar', component: Canastainsert },
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'detalle',
    component: Detalle,
    children: [
      { path: 'listar', component: Detallelistar },
      { path: 'insertar', component: Detalleinsert },
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'tiporesena',
    component: Tiporesena,
    children: [{ path: 'listar', component: Tiporesenalistar }],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'historialprecio',
    component: Historialprecio,
    children: [{ path: 'listar', component: Historialpreciolistar }],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'ofertasproducto',
    component: Ofertasproductoinsert,
    children: [{ path: 'lista', component: Ofertasproductolistar }],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'ubicaciontienda',
    component: Ubicaciontienda,
    children: [
      { path: 'lista', component: Ubicaciontiendalistar },
      { path: 'insertar', component: Ubicaciontiendainsert },
    ],
    //canActivate: [seguridadGuard],
  },


];
