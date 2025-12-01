import { DistritoInsertModel } from './distritoinsert';
import { Tienda } from './tienda';

export class Ubicaciontienda {
  idUbiTienda: number = 0;
  direccionUbiTienda: string = '';
  detalleLineaTienda: string = '';
  longitudUbiTienda: number = 0;
  latitudUbiTienda: number = 0;
  createdUT: Date = new Date();
  distrito: DistritoInsertModel = new DistritoInsertModel();
  tiendaa: Tienda = new Tienda();
}
