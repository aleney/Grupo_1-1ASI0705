import { ProductoInsert } from "./productoinsert"

export class Ofertasproducto {
    idOfertasproducto: number=0
    fechainicio: Date=new Date()
    fechafin: Date=new Date()
    createdAt: Date=new Date()
    producto: ProductoInsert = new ProductoInsert()
}

