import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ResGastos } from 'src/app/modules/dashboard/model/res-gastos';
import { PruebaService } from 'src/app/modules/dashboard/services/prueba.service';

@Component({
  selector: 'app-hoja',
  templateUrl: './hoja.component.html',
  styleUrls: ['./hoja.component.css']
})
export class HojaComponent implements OnInit {

  listaDatos:any;

  constructor(private pruebaService:PruebaService, private router:Router) {    
   }

  ngOnInit(): void {
    this.pruebaService.obtenerGastos().subscribe(
      data => {
        this.listaDatos = data.response;     
        console.log(this.listaDatos)
      },
      err => {
        alert("Algo ha fallado");        
      })
  }
  editableId(id:number,dato:any){
    console.log(id);
    console.log(dato)
  }
  trashId(id:number){
    console.log(id)
  }
}
