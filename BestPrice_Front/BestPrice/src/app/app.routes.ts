import { Routes } from '@angular/router';
import { Menu } from './components/menu/menu';
import { Lineatiendasinsert } from './components/lineatiendas/lineatiendasinsert/lineatiendasinsert';
import { Distritoinsert } from './components/distrito/distritoinsert/distritoinsert';
import { Ubicaciontiendainsert } from './components/ubicaciontienda/ubicaciontiendainsert/ubicaciontiendainsert';
import { Historialprecioinsert } from './components/historialprecio/historialprecioinsert/historialprecioinsert';
import { Ofertasproductoinsert } from './components/ofertasproducto/ofertasproductoinsert/ofertasproductoinsert';
import { Tiendainsert } from './components/tienda/tiendainsert/tiendainsert';
import { Productoinsert } from './components/producto/productoinsert/productoinsert';
import { Distritolistar } from './components/distrito/distritolistar/distritolistar';
import { Productolistar } from './components/producto/productolistar/productolistar';
import { Tiendalistar } from './components/tienda/tiendalistar/tiendalistar';
import { Historialpreciolistar } from './components/historialprecio/historialpreciolistar/historialpreciolistar';
import { Ofertasproductolistar } from './components/ofertasproducto/ofertasproductolistar/ofertasproductolistar';
import { Ubicaciontiendalistar } from './components/ubicaciontienda/ubicaciontiendalistar/ubicaciontiendalistar';
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
import { Usuariolist } from './components/usuario/usuariolist/usuariolist';
import { Rol } from './components/rol/rol';
import { RolList } from './components/rol/rollist/rollist';
import { Ticketreporte } from './components/ticketreporte/ticketreporte';
import { TicketReporteList } from './components/ticketreporte/ticketreportelist/ticketreportelist';
import { Ticketrespuesta } from './components/ticketrespuesta/ticketrespuesta';
import { Ticketrespuestalist } from './components/ticketrespuesta/ticketrespuestalist/ticketrespuestalist';
import { UsuarioInsert } from './components/usuario/usuarioinsert/usuarioinsert';
import { Usuario } from './components/usuario/usuario';


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
      { path: 'insertar', component: Productoinsert }
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'categoriaproducto',
    component: Categoriaproducto,
    children: [
      { path: 'insertar', component: Categoriaproductoinsert },
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
      { path: 'listar', component: Tipotiendalistar },
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
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'distrito',
    component: Distrito,
    children: [
      { path: 'listar', component: Distritolistar },
      { path: 'insertar', component: Distritoinsert }
    ],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'historialprecio',
    component: Historialprecioinsert,
    children: [
      { path: 'lista', component: Historialpreciolistar },
      { path: 'lista', component: Productolistar }
    ],
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
    component: Ubicaciontiendainsert,
    children: [{ path: 'lista', component: Ubicaciontiendalistar }],
    //canActivate: [seguridadGuard],
  },

  {
    path: 'usuario', component: Usuario, 
    children: 
    [{path: 'list', component: Usuariolist},
    {path: 'insert', component: UsuarioInsert}]
  },  
  {
    path: 'rol', component: Rol,
    children:[   
      {
        path: 'list', component: RolList
      }
    ]
  },
  {
    path: 'ticketreporte', component: Ticketreporte,
    children:[
      {
        path: 'list', component: TicketReporteList
      }
    ]
  },
  {
    path: 'ticketrespuesta', component: Ticketrespuesta,
    children:[
      {
        path: 'list', component: Ticketrespuestalist
      }
    ]
  }
];
