import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AboudUs } from '../models/aboudUS';

@Injectable({
  providedIn: 'root'
})
export class AboudUSService {

  constructor(private http:HttpClient) { }

  URL = environment.baseUrl;

  //Obtiene los datos de los participantes
  public obtenerDatos():Observable<AboudUs>{
    return this.http.get<AboudUs>(this.URL + "aboud/findAll")
  }
  
}
