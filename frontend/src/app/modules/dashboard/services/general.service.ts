import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Movimiento } from '../model/movimiento';

@Injectable({
  providedIn: 'root'
})
export class GeneralService {

  constructor(private http:HttpClient) { }

  URL = environment.baseUrl + "expenses/";
  
  //OBTENER GASTOS
  public obtenerDatos():Observable<any>{
    return this.http.get<any>(this.URL + "user/home")    
  }

  //TODO:Buscar metodo
  //BUSCAR POR ID
  public buscarGasto(id:number):Observable<Movimiento>{
    return this.http.get<Movimiento>(this.URL + `buscar/${id}`)
  }

  //CREAR
  public guardarGasto(movimiento:Movimiento):Observable<any>{
    return this.http.post<any>(this.URL + "save",movimiento)
  }

   //TODO:Buscar metodo
  //ACTUALIZAR
  public actualizarGasto(id:number,movimiento:Movimiento,httpHeaders:HttpHeaders):Observable<any>{    
  return this.http.put<any>(this.URL + `editar/${id}`,movimiento,{})
  }

  //BORRAR
  public borrarGasto(id:number):Observable<any>{
    return this.http.delete<any>(this.URL + `delete/${id}`)
  }

}

