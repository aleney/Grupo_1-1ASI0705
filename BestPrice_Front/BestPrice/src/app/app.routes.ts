import { Routes } from '@angular/router';
import { Menu } from './components/menu/menu';
import { Lineatiendasinsert } from './components/lineatiendas/lineatiendasinsert/lineatiendasinsert';
import { Distritoinsert } from './components/distrito/distritoinsert/distritoinsert';
import { Ubicaciontiendainsert } from './components/ubicaciontienda/ubicaciontiendainsert/ubicaciontiendainsert';
import { Ofertasproductoinsert } from './components/ofertasproducto/ofertasproductoinsert/ofertasproductoinsert';
import { Tiendainsert } from './components/tienda/tiendainsert/tiendainsert';
import { Productoinsert } from './components/producto/productoinsert/productoinsert';
import { Distritolistar } from './components/distrito/distritolistar/distritolistar';
import { Productolistar } from './components/producto/productolistar/productolistar';
import { Tiendalistar } from './components/tienda/tiendalistar/tiendalistar';
import { Historialpreciolistar } from './components/historialprecio/historialpreciolistar/historialpreciolistar';
import { Ofertasproductolistar } from './components/ofertasproducto/ofertasproductolistar/ofertasproductolistar';
import { Ubicaciontiendalistar } from './components/ubicaciontienda/ubicaciontiendalistar/ubicaciontiendalistar';
import { seguridadGuard } from './guard/seguridad-guard';
import { Autenticador } from './components/autenticador/autenticador';
import { Distrito } from './components/distrito/distrito';
import { Tienda } from './components/tienda/tienda';
import { Producto } from './components/producto/producto';
import { Categoriaproducto } from './components/categoriaproducto/categoriaproducto';
import { Categoriaproductoinsert } from './components/categoriaproducto/categoriaproductoinsert/categoriaproductoinsert';
import { Lineatiendas } from './components/lineatiendas/lineatiendas';
import { Lineatiendaslist } from './components/lineatiendas/lineatiendaslist/lineatiendaslist';
import { Tipotiendalistar } from './components/tipotienda/tipotiendalistar/tipotiendalistar';
import { Tipotiendainsertar } from './components/tipotienda/tipotiendainsertar/tipotiendainsertar';
import { Categoriaproductolistar } from './components/categoriaproducto/categoriaproductolistar/categoriaproductolistar';
import { Ofertasproducto } from './components/ofertasproducto/ofertasproducto';
import { Canasta } from './components/canasta/canasta';
import { Canastalistar } from './components/canasta/canastalistar/canastalistar';
import { Canastainsert } from './components/canasta/canastainsert/canastainsert';
import { Detalle } from './components/detalle/detalle';
import { Detallelistar } from './components/detalle/detallelistar/detallelistar';
import { Detalleinsert } from './components/detalle/detalleinsert/detalleinsert';
import { Tiporesena } from './components/tiporesena/tiporesena';
import { Tiporesenalistar } from './components/tiporesena/tiporesenalistar/tiporesenalistar';
import { Historialprecio } from './components/historialprecio/historialprecio';
import { Lineatiendaanio2025 } from './models/lineatiendaanio2025';
import { Ubicaciontienda } from './components/ubicaciontienda/ubicaciontienda';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'menu',
    pathMatch: 'full',
  },

  {
    path: 'login',
    component: Autenticador,
  },

  { path: 'menu', component: Menu },

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
    path: 'lineatiendas',
    component: Lineatiendas,
    children: [
      { path: 'listar', component: Lineatiendaslist },
      { path: 'insertar', component: Lineatiendasinsert },
      { path: 'lineatiendas-anioactual', component: Lineatiendaanio2025 },
    ],
    //canActivate: [seguridadGuard],
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
