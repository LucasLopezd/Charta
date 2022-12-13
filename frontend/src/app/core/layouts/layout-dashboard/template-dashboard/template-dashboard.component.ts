import { ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewEncapsulation } from '@angular/core';
import { SideService } from '../service/side.service';

@Component({
  selector: 'template-dashboard',
  templateUrl: './template-dashboard.component.html',
  styleUrls: ['./template-dashboard.component.scss']
})
export class TemplateDashboardComponent implements OnInit {
  changer:boolean = false;

  constructor(private sideServ: SideService) { }

  ngOnInit(): void {
    this.sideServ.$change.subscribe((valor)=>{
      this.changer = valor;
    }) 
  }
  

}
