import { Component } from "@angular/core";
import { ActivatedRoute, RouterOutlet } from "@angular/router";
import { RolInsert } from "./rolinsert/rolinsert";

@Component({  
  selector: 'app-rol',
  imports: [RouterOutlet, RolInsert],
  templateUrl: './rol.html',
  styleUrl: './rol.css',
})
export class Rol {
  constructor(public route:ActivatedRoute){}
}