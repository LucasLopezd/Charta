import { Pipe, PipeTransform } from '@angular/core';
import { Ingreso } from '../model/ingreso';

@Pipe({
  name: 'paginacionIngreso'
})
export class PaginacionIngresoPipe implements PipeTransform {

  transform(lista: Ingreso[], page:number=0,orden:string="recientes"): Ingreso[] {
    
    if (orden==""){
      return lista.slice(page,page+10)       
    } else if (orden==="mayores"){
        const listaFiltrada = lista.sort((a,b)=>b.importe-a.importe);
        return listaFiltrada.slice(page,page+10) 
    } else if (orden==="menores"){
        const listaFiltrada = lista.sort((a,b)=>a.importe-b.importe);
        return listaFiltrada.slice(page,page+10) 
    } else if (orden==="antiguos")  {
        const listaFiltrada = lista.sort((a,b)=>a.fecha.valueOf()-b.fecha.valueOf());
        return listaFiltrada.slice(page,page+10)
    } else if (orden==="recientes") {
      const listaFiltrada = lista.sort((a,b)=>b.fecha.valueOf()-a.fecha.valueOf());
      return listaFiltrada.slice(page,page+10)
    } 
    return lista
  }

}
