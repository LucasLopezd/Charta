import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { TokenService } from '../services/token.service';

@Injectable({
  providedIn: 'root'
})
export class GuardGuard implements CanActivate {

    realRol: string="";
  
    constructor(private tokenService: TokenService, private router: Router) { }
    
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
      const expectedRol = route.data['expectedRol'];
      const token = this.tokenService.getToken();
      this.realRol = 'visited';
      if (this.tokenService.getToken()) {
          this.realRol = 'user';                 
      } else {
        this.router.navigate(['/']);
        return false;
      }
      return true
    }
  }
 
  

