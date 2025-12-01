import { CategoriaProducto } from "./categoriaproducto"
import { Tienda } from "./tienda"

export class ProductoInsert {
    idProducto: number = 0
    nombreProducto: string = ""
    descripcionProducto: string = ""
    marcaProducto: string = ""
    precioProducto: number = 0
    stockProducto: number = 0
    unidadMetricaProducto: number = 0
    favoritoProducto: boolean = false
    disponibleProducto: boolean = false
    categoriaProducto: CategoriaProducto = new CategoriaProducto()
    tienda: Tienda = new Tienda()
}