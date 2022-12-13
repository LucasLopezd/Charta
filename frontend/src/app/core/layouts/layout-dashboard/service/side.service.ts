import { EventEmitter, Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SideService {

  $change = new EventEmitter<boolean>();

  constructor() { }

  
}
