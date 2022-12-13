import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'ingreso'
})
export class IngresoPipe implements PipeTransform {

  transform(listaIngreso: any, page:number=0,orden:string=""): any {
    
    if (orden==""){
      return listaIngreso.slice(page,page+10)       
    } else if (orden==="mayores"){
        const listaFiltrada = listaIngreso.sort((a: { importe: number; },b: { importe: number; })=>b.importe-a.importe);
        return listaFiltrada.slice(page,page+10) 
    } else if (orden==="menores"){
        const listaFiltrada = listaIngreso.sort((a: { importe: number; },b: { importe: number; })=>a.importe-b.importe);
        return listaFiltrada.slice(page,page+10) 
    } else if (orden==="antiguos")  {
        const listaFiltrada = listaIngreso.sort((a: { fecha: string; },b: { fecha: string})=>(new Date(a.fecha)).valueOf()- (new Date(b.fecha)).valueOf());
        return listaFiltrada.slice(page,page+10)
    } else if (orden==="recientes") {
      const listaFiltrada = listaIngreso.sort((a: { fecha: string; },b: { fecha: string; })=>(new Date(b.fecha)).valueOf()- (new Date(a.fecha)).valueOf());
      return listaFiltrada.slice(page,page+10)
    } 
    return listaIngreso
  }

}
