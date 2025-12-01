import { Rol } from "./rol";
export class Usuarioinsert{ 
    idUsuario: number = 0 
    nombre: string = "" 
    password: string = "" 
    numeroTelefono: string = "" 
    estado: boolean = false 
    rol: Rol = new Rol() 
}
