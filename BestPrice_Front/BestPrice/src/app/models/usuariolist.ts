import { Rol } from "./rol";
export class UsuarioList{ 
    idUsuario: number = 0 
    nombre: string = "" 
    numeroTelefono: string = "" 
    estado: boolean = false 
    createdAt : Date = new Date() 
    updatedAt : Date = new Date() 
    rol: Rol = new Rol() 
}