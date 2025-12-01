import { Producto } from "./producto"

export class Tienda {
    idTienda: number = 0
    nombreTienda: string = ""
    descripcionTienda: string = ""
    numeroTelefono: string = ""
    estadoTienda: boolean = false
    fechaTienda: Date = new Date()
    prodc: Producto = new Producto()
}

