import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Ingreso } from '../model/ingreso';

@Injectable({
  providedIn: 'root'
})
export class IngresosService {

  constructor(private http:HttpClient) { }

  URL = environment.baseUrl + "incomes/";
  
  //OBTENER DATOS
  public obtenerIngresos():Observable<any>{
    console.log("El Servicio Obtener Ingreso esta corriendo");
    console.log(this.URL + "finAll")
    return this.http.get<any>(this.URL + "findAll")    
  }

  //BUSCAR POR ID
  /*
  public buscarIngreso(id:number):Observable<Ingreso>{
    return this.http.get<Ingreso>(this.URL + `buscar/${id}`)
  }*/

  //CREAR
  public guardarIngreso(ingreso:Ingreso|any):Observable<any>{
    console.log("El Servicio Guardar Ingreso esta cooriendo");
    console.log(this.URL + "save")
    return this.http.post<any>(this.URL + "save",ingreso)
  }

  //ACTUALIZAR
  public actualizarIngreso(id:number,ingreso:Ingreso|any,httpHeaders:HttpHeaders):Observable<any>{  
    console.log("El Servicio Actualizar Ingreso esta corriendo");
    console.log(this.URL + `update/${id}`)  
    return this.http.post<any>(this.URL + `update/${id}`,ingreso,{})
  }

  //ELIMINAR
  public borrarIngreso(id:number):Observable<any>{
    console.log("El servicio de eliminado esta corriendo");
    console.log(this.URL + `delete/${id}`);
    return this.http.delete<any>(this.URL + `delete/${id}`)
  }

}