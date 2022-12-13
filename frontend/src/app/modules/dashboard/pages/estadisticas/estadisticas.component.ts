import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js';
import { GastosService } from '../../services/gastos.service';
import { IngresosService } from '../../services/ingresos.service';
import { Gasto } from '../../model/gasto';
import { Ingreso } from '../../model/ingreso';

@Component({
  selector: 'app-estadisticas',
  templateUrl: './estadisticas.component.html',
  styleUrls: ['./estadisticas.component.css']
})
export class EstadisticasComponent implements OnInit {   
  
  listaIngreso:Ingreso[]=[];
  listaGasto:Gasto[]=[];

  gastoTotal:number=0;
  ingresoTotal:number=0;

  listaIngresoImporte:any[]=[];
  listaGastoImporte:any[]=[];

  labelCategoria:any[]=[];  

  constructor(
    private gasto: GastosService,
    private ingreso: IngresosService
  ) { }

  ngOnInit(): void {
    
  this.gasto.obtenerGastos().subscribe(
    data =>{
     this.listaGasto = data; 
     if(this.listaGasto!=null){
        this.gastoTotal = this.listaGasto.reduce((sum:number, total:Gasto) => sum + total.importe,0)
      console.log(this.gastoTotal)
     }     
    console.log(this.listaGasto)
  })
    
    console.log(this.listaGasto)
    /*
    this.obtenerIngresos();

    this.obtenerGastoTotal();
    this.obtenerIngresoTotal();

    this.obtenerLabelsRadar();*/

    /*RENDER DE LAS ESTADISTICAS*/


    this.renderPieChart(22,28,40,10,'pieChartGeneral');/*
    this.renderRadarChart(this.listaGastoImporte ,this.labelCategoria,'radarChartIncomesExpenses');*/
    this.renderLineChart(this.listaGastoImporte, this.listaIngresoImporte, 'barChartIncomesExpensesMonths')
    this.renderPieChart2(78000,94500,'pieChartGeneral2');
    this.renderDoughnutChart(this.gastoTotal,this.ingresoTotal,this.gastoTotal,'dona');
  }
  
/* GET DATOS */
  /*
  obtenerIngresos(){
    this.ingreso.obtenerIngresos().subscribe(
      data =>{
        this.listaIngreso = data;  
        console.log(this.listaIngreso)})
  }

  /*FILTRADO DE DATA PARA LAS ESTADISTICAS*/
  
/** 
obtenerGastoTotal(){
 this.gastoTotal = this.listaGasto.reduce((sum:number, total:Gasto) => sum + total.importe,0);
 console.log(this.gastoTotal);
}

obtenerIngresoTotal(){
  this.ingresoTotal = this.listaIngreso.reduce((sum:number, total:Ingreso) => sum + total.importe, 0);
}

obtenerLabelsRadar(){
  this.labelCategoria = [...new Set(this.listaGasto.map(g => g.categoria))] 
}
*/
  /* RENDER CHARTS*/
  
  renderPieChart2(gastoTotal:number, ingresoTotal:number ,id:any){
    const chart  = new Chart(id,{
      type:"pie",
      data:{
        labels:['Gasto total', 'Ingreso total'],
        datasets:[
          {
            data:[gastoTotal, ingresoTotal],
            backgroundColor:[
              'rgba(93, 33, 210, 0.2)',
              'rgba(255, 99, 12, 0.2)'
            ],
            borderColor:[
              'rgba(93, 33, 210)',
              'rgba(255, 99, 12)'
            ]
          }
        ]
      } 
    });
  }
  /*------------------------------------------------------------*/
  /*-------Hardcodeado por categoría--------*/
  renderPieChart(alimentos:number, servicios:number ,movilidad:number,varios:number,id:any){
    const chart  = new Chart(id,{
      type:"pie",
      data:{
        labels:['Movilidad', 'Servicios','Alimentos','Varios'],
        datasets:[
          {
            data:[alimentos, servicios,movilidad,varios],
            backgroundColor:[
              'rgba(229, 35, 35)',
              'rgba(34, 133, 34)',
              'rgba(229, 229, 35)',
              'rgba(37, 192, 197)'
            ],
            borderColor:[
              'rgba(93, 33, 210)',
              'rgba(93, 33, 210)',
              'rgba(93, 33, 210)',
              'rgba(93, 33, 210)'
            ]
          }
        ]
      } 
    });
  }

  renderRadarChart( listaGastoImporte:any,labelCategoria:any ,id:any){
    const chart  = new Chart(id,{
      type:"radar",
      data:{
        labels: labelCategoria
        /*
        comida;
        viajes;
        servicios;
        etc
        */ ,
        datasets: [{
          label: 'Enero',
          data: /*listaGastoImporte*/[25,32,48,78],
          fill: true,
          backgroundColor: 'rgba(255, 99, 132, 0.2)',
          borderColor: 'rgb(255, 99, 132)',
          pointBackgroundColor: 'rgb(255, 99, 132)',
          pointBorderColor: '#fff',
          pointHoverBackgroundColor: '#fff',
          pointHoverBorderColor: 'rgb(255, 99, 132)'
        }                    
      ]}
    });
  }

  renderLineChart(listaGastoImporte:any,listaIngresoImporte:any ,id:any){
    const chart  = new Chart(id,{
      type:"bar",
      data:{
        labels:['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
        datasets:[
          {
            label:'Ingresos',
            data: /*listaIngresoImporte */[102000,113000,104000,105000,97000,110000,109000,98500,92000,96000,99000,94000],
            backgroundColor:[
              'rgba(109, 179, 29)'    
            ],
            borderColor:
            'rgba(93, 33, 210)'
          },
          {
          label:'Gastos',
          data: /*listaGastoImporte*/[ 83000,84000,85000,93000,83000,84000,85000,73000,87000,91000,88000,81000],
          backgroundColor:[
          'rgba(232, 229, 32)'    
          ],
          borderColor:
          'rgba(93, 33, 210)'
          }
        ]
      } 
    });
  }

  renderDoughnutChart(a:number, b:number,c:number ,id:any){
    const config = {
      type: 'doughnut',
      data:{
        labels: [
          'Red',
          'Blue',
          'Yellow'
        ],
        datasets: [{
          label: 'My First Dataset',
          data: [1000,1500,2400],
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
          ],
          hoverOffset: 4
        }]
      }
    };
  }
}
