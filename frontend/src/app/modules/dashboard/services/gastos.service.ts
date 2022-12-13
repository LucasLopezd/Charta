import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Gasto } from '../model/gasto';
import { environment } from 'src/environments/environment';
import { ResGastos } from '../model/res-gastos';

@Injectable({
  providedIn: 'any'
})
export class GastosService {

  constructor(private http:HttpClient) { }

  URL = environment.baseUrl + "expenses/";

  httpOptions : any    = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Allow-Methods': 'POST',
      'Access-Control-Allow-Origin': '*'
    })
  };
  
  //OBTENER GASTOS
  public obtenerGastos():Observable<any>{
    return this.http.get<any>(this.URL + "user/findAll")    
  }

  //BUSCAR POR ID
  /*public buscarGasto(id:number):Observable<Gasto>{
    return this.http.get<Gasto>(this.URL + `buscar/${id}`)
  }*/

  //CREAR
  public guardarGasto(gasto:any):Observable<any>{
    console.log("El Servicio CREAR GASTO esta corriendo");
    console.log(this.URL + "save")
    return this.http.post<any>(this.URL + "save",gasto)
  }

  //ACTUALIZAR
  public actualizarGasto(id:number,gasto:any,headers:HttpHeaders):Observable<any>{    
  return this.http.post<any>(this.URL + `update/${id}`,gasto,{})
  }

  //ELIMINAR
  public borrarGasto(id:number):Observable<any>{
    console.log("El servicio de eliminado esta corriendo");
    console.log(this.URL + `delete/${id}`)
    return this.http.delete<any>(this.URL + `delete/${id}`)
  }

  //FILTRAR
  public filtrarGastos():Observable<any>{
    console.log("Servicio de Filtrado corriendo");
    return this.http.get<any>(this.URL + "user/findAll")
  }
}