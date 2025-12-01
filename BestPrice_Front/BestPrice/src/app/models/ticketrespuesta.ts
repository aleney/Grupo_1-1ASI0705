import { TicketReporte } from "./ticketreporte"
import { UsuarioList } from "./usuariolist"

export class TicketRespuesta{
    idTicketRes:number=0
    detalle:string=''
    createdAt : Date = new Date() 
    ticketreporte: TicketReporte = new TicketReporte
    usuario: UsuarioList = new UsuarioList
}