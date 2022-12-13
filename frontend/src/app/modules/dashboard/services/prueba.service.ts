import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Prueba } from '../model/prueba';
import { ResPrueba } from '../model/resPrueba';

@Injectable({
  providedIn: 'root'
})
export class PruebaService {

  constructor(private http:HttpClient) { }

  gastoURL = environment.baseUrl + "expenses/";
  
  //OBTENER GASTOS
  public obtenerGastos():Observable<ResPrueba>{
    return this.http.get<ResPrueba>(this.gastoURL + "user/findAll")    
  }
}
