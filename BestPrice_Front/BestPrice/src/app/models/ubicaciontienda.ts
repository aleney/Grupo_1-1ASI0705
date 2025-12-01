import { Distrito } from './distrito';
import { Tienda } from './tienda';

export class Ubicaciontienda {
  idUbiTienda: number = 0;
  direccionUbiTienda: string = '';
  detalleLineaTienda: string = '';
  longitudUbiTienda: number = 0;
  latitudUbiTienda: number = 0;
  createdUT: Date = new Date();
  distrito: Distrito = new Distrito();
  tiendaa: Tienda = new Tienda();
}
