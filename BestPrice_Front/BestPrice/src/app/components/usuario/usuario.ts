import { Component } from "@angular/core";
import { ActivatedRoute, RouterOutlet } from "@angular/router";
import { UsuarioInsert } from "./usuarioinsert/usuarioinsert";

@Component({  
  selector: 'app-usuario',
  imports: [RouterOutlet, UsuarioInsert],
  templateUrl: './usuario.html',
  styleUrl: './usuario.css',
})
export class Usuario {
  constructor(public route:ActivatedRoute){}
}
