import { Pipe, PipeTransform } from '@angular/core';
import { Gasto } from '../model/gasto';

@Pipe({
  name: 'paginacion'
})
export class PaginacionPipe implements PipeTransform {

  transform(lista: Gasto[], page:number=0,orden:string=""): Gasto[] {
    
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
