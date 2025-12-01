import { UsuarioList } from "./usuariolist"


export class TicketReporte{
    idTicketRep:number=0
    detalle:string=''
    createdAt : Date = new Date() 
    ticketStatus:boolean=false
    usuario: UsuarioList = new UsuarioList
}