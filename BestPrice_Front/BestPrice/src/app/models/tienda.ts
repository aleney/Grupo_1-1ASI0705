import { LineatiendaInsert } from "./lineatiendainsert"
import { TipoTienda } from "./tipotienda"

export class Tienda {
    idTienda: number = 0
    nombreTienda: string = ""
    descripcionTienda: string = ""
    numeroTelefono: string = ""
    estadoTienda: boolean = false
    createdAtLineaTienda: Date=new Date()
    lineaTienda: LineatiendaInsert = new LineatiendaInsert()
    tipoTienda: TipoTienda = new TipoTienda()
}

