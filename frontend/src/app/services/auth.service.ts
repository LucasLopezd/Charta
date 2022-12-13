import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JwtDTO } from '../modules/auth/models/jwt-dto';
import { LoginUsuario } from '../modules/auth/models/login-usuario';
import { NuevoUsuario } from '../modules/auth/models/nuevo-usuario';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  URL = environment.baseUrl + "/users";

  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevoUsuario: NuevoUsuario): Observable<any> {
    return this.httpClient.post<any>(this.URL + 'register', nuevoUsuario);
  }

  public login(loginUsuario: LoginUsuario): Observable<JwtDTO> {
    return this.httpClient.post<JwtDTO>(URL + 'login', loginUsuario)
  }

  public logOut(): void{
    window.sessionStorage.clear();
  }
  
}
