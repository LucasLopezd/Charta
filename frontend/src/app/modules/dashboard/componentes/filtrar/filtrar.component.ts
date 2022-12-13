import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-filtrar',
  templateUrl: './filtrar.component.html',
  styleUrls: ['./filtrar.component.css']
})
export class FiltrarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  filtrar(){
    console.log("Se esta filtrando")
  }

}
