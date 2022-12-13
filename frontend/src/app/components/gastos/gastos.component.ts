import { Component, OnInit } from '@angular/core';
import { ResGastos } from 'src/app/modules/dashboard/model/res-gastos';
import { GastosService } from 'src/app/modules/dashboard/services/gastos.service';
import { HojaService } from 'src/app/services/hoja.service';

@Component({
  selector: 'app-gastos',
  templateUrl: './gastos.component.html',
  styleUrls: ['./gastos.component.css']
})
export class GastosComponent implements OnInit {

  listaGastos:ResGastos[]=[]

  constructor(private hojaService:HojaService) { }

  ngOnInit(): void {  
    this.obtenerGastos();    
  }

  // Obtener Gastos
  obtenerGastos(){
    this.hojaService.obtenerGastos().subscribe(
      data =>{
        this.listaGastos = data.response;      
        console.log(this.listaGastos)
      },    
      err => {/*
        this.isLogged = false;
        this.errMsj = err.error.message;
        alert("Algo ha fallado");
        this.router.navigate(['/']);*/
        console.error("Los datos del servidor no llegan");
        console.log(err);
      });
  }

}
