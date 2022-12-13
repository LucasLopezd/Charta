import {  ChangeDetectionStrategy, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { SwitchService } from '../../../services/switch.service';
import Swal from 'sweetalert2';
import { SideService } from '../service/side.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'dashboard-layout',
  templateUrl: './menu-dashboard.component.html',
  styleUrls: ['./menu-dashboard.component.scss']
})
export class MenuDashboardComponent implements OnInit {
  modalSwith: boolean = false;
  changer: boolean = false;
  @Output() change = new EventEmitter();

  constructor(public authService:AuthService,public router: Router, private modalService: SwitchService, public sideServ: SideService) { }

  ngOnInit(): void {
    this.modalService.$modal.subscribe((valor) => {
      this.modalSwith = valor
    })
    
    this.sideServ.$change.subscribe((valor)=>{
      this.changer = valor;
    }) 
    
    
  }
  

  openModal(): void {
    this.modalSwith = true;
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
        console.log("cerrando sesion")
        this.router.navigateByUrl('/landing')
      }
    })
  }
  
  op(){
    this.changer = !this.changer;
    this.changer = !this.changer; 
  }
}
