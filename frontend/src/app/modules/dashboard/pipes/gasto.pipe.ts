
import { Pipe, PipeTransform } from '@angular/core';
import { Subscription } from 'rxjs';

@Pipe({
  name: 'gasto'
})
export class GastoPipe implements PipeTransform {

  transform(listaGastos:any= Subscription, page:number=0,orden:string=""): any {
    
    if (orden==""){
      return listaGastos.slice(page,page+10)       
    } else if (orden==="mayores"){
        const listaFiltrada = listaGastos.sort((a: { importe: number; },b: { importe: number; })=>b.importe-a.importe);
        return listaFiltrada.slice(page,page+10) 
    } else if (orden==="menores"){
        const listaFiltrada = listaGastos.sort((a: { importe: number; },b: { importe: number; })=>a.importe-b.importe);
        return listaFiltrada.slice(page,page+10) 
    } else if (orden==="antiguos")  {
        const listaFiltrada = listaGastos.sort((a: { fecha: string; },b: { fecha: string})=>(new Date(a.fecha)).valueOf()- (new Date(b.fecha)).valueOf());
        return listaFiltrada.slice(page,page+10)
    } else if (orden==="recientes") {
      const listaFiltrada = listaGastos.sort((a: { fecha: string; },b: { fecha: string; })=>(new Date(b.fecha)).valueOf()- (new Date(a.fecha)).valueOf());
      return listaFiltrada.slice(page,page+10)
    } 
    return listaGastos
  }

}
