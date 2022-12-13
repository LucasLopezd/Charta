import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';
import { SideService } from '../service/side.service';

@Component({
  selector: 'header-layout',
  templateUrl: './header-com.component.html',
  styleUrls: ['./header-com.component.css']
})
export class HeaderComComponent implements OnInit {

  changer: boolean = true;

  constructor(private authService:AuthService, public sideSer: SideService, private router:Router) { }
  

  ngOnInit(): void {
  
  }

  cambiar(){
    this.changer = !this.changer;
    // this.sideSer.$change = !this.sideSer.change;
    this.sideSer.$change.emit(this.changer);

  }

  closeSession() {
    Swal.fire({
      title: '¿Estas seguro?',
      text: "Seras redirigido a la landing page",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, estoy seguro!'
    }).then((result:any) => {
      if (result.isConfirmed) {
        this.authService.logOut();
        this.router.navigateByUrl('/landing')
      }
    })
  }
  

}
