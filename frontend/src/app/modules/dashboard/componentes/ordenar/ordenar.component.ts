import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { runInThisContext } from 'vm';

@Component({
  selector: 'app-ordenar',
  templateUrl: './ordenar.component.html',
  styleUrls: ['./ordenar.component.css']
})
export class OrdenarComponent implements OnInit {

  @Output() mensaje = new EventEmitter<string>();

  palabra:string="Ordenar por";

  constructor() { }

  ngOnInit(): void {
  }

  masRecientes(){
    this.mensaje.emit("recientes");
    this.palabra="Mas recientes"
  }
  masAntiguos(){
    this.mensaje.emit("antiguos");
    this.palabra="Mas antiguos"
  }
  mayorImporte(){
    this.mensaje.emit("mayores");
    this.palabra="Mayor importe"
  }
  menorImporte(){
    this.mensaje.emit("menores");
    this.palabra="Menor importe"
  }

}
