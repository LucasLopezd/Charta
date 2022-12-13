import { HttpHeaders } from '@angular/common/http';
import { ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { Ingreso } from '../../model/ingreso';
import { FechaService } from '../../services/fecha.service';
import { IngresosService } from '../../services/ingresos.service';

@Component({
  selector: 'app-ingresos',
  templateUrl: './ingresos.component.html',
  styleUrls: ['./ingresos.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class IngresosComponent implements OnInit {

  listaIngreso:any;
  hardcodeo:boolean=false;
  active:boolean=true;

  // (Variable que forma parte de la directiva Recargar
  recargar:number=0;

  //fecha:any;  

  addIngresoForm:FormGroup;
  editIngresoForm:FormGroup;

  listaIngreso$:Subscription;

  
  lista2Ingresos:Ingreso[]=[];

  nuevoIngreso:Ingreso[]=[];
  editId:number=0;
  borrarId:number=0;

  // Paginación
  page:number=0;
  orden:string="";

  // Lista hardcodeada
  listilla = [
    {
        fecha:new Date('2022-3-17'),
        categoria:'Anual',
        descripcion:'Acciones en CHARTA',
        importe:2500000
    },
    {
        fecha:new Date('2021-8-5'),
        categoria:'Anual',
        descripcion:'Acciones en twitter',
        importe:300
    },
    {
        fecha:new Date('2020-10-9'),
        categoria:'Mensual',
        descripcion:'Sueldo',
        importe:150000
    },
    {
        fecha:new Date('2019-5-8'),
        categoria:'Semanal',
        descripcion:'Ingreso panadería',
        importe:20000
    },
    {
        fecha:new Date('1999-6-5'),
        categoria:'Diario',
        descripcion:'Dinero encontrado en la calle',
        importe:8500
    },
    {
        fecha:new Date('2005-4-12'),
        categoria:'Semanal',
        descripcion:'ingreso peluquería',
        importe:10500
    },
    {
        fecha:new Date('1982-4-27'),
        categoria:'Mensual',
        descripcion:'Sueldo 2',
        importe:115000
    },
    {
        fecha:new Date('1995-9-23'),
        categoria:'Diario',
        descripcion:'Regalo de la tia',
        importe:25000
    },
    {
        fecha:new Date('1980-11-12'),
        categoria:'Anual',
        descripcion:'Acciones en Spice Girls',
        importe:50000
    },
    {
      fecha:new Date('2022-3-17'),
      categoria:'Anual',
      descripcion:'Acciones en CHARTA',
      importe:2500000
  },
  {
      fecha:new Date('2021-8-5'),
      categoria:'Anual',
      descripcion:'Acciones en twitter',
      importe:300
  },
  {
      fecha:new Date('2020-10-9'),
      categoria:'Mensual',
      descripcion:'Sueldo',
      importe:150000
  },
  {
      fecha:new Date('2019-5-8'),
      categoria:'Semanal',
      descripcion:'Ingreso panadería',
      importe:20000
  },
  {
      fecha:new Date('1999-6-5'),
      categoria:'Diario',
      descripcion:'Dinero encontrado en la calle',
      importe:8500
  },
  {
      fecha:new Date('2005-4-12'),
      categoria:'Semanal',
      descripcion:'ingreso peluquería',
      importe:10500
  },
  {
      fecha:new Date('1982-4-27'),
      categoria:'Mensual',
      descripcion:'Sueldo 2',
      importe:115000
  },
  {
      fecha:new Date('1995-9-23'),
      categoria:'Diario',
      descripcion:'Regalo de la tia',
      importe:25000
  },
  {
      fecha:new Date('2022-11-24'),
      categoria:'Anual',
      descripcion:'Acciones en Spice Girls',
      importe:50000
  }
  ];
  
  httpOptions : any    = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Access-Control-Allow-Headers': 'Content-Type',
      'Access-Control-Allow-Methods': 'PUT',
      'Access-Control-Allow-Origin': '*'
    })
  }; 
  
  constructor(private fechaService: FechaService,
              private formBuilder:FormBuilder, 
              private ingresoService:IngresosService) {
    // Formulario Nuevo Ingreso
    this.addIngresoForm = this.formBuilder.group(
      {      
        fecha: ['', [Validators.required]],
        tipo: ['',[Validators.required]],
        importe:['',[Validators.required,Validators.min(0)]],
        descripcion:['',[Validators.required,Validators.maxLength(14)]],
        monedaId:1,
        esIncluida:true
      }
    )
    // Formulario Editar Ingreso
    this.editIngresoForm = this.formBuilder.group(
      {      
        fecha: ['', [Validators.required]],
        tipo: ['',[Validators.required]],
        importe:['',[Validators.required,Validators.min(0)]],
        descripcion:['',[Validators.required,Validators.maxLength(14)]],
        esIncluida:true
      }
    )
    this.listaIngreso$ = this.ingresoService.obtenerIngresos().subscribe(
      (data) => this.listaIngreso = data.response
    )
  }

  ngOnInit(): void {
    this.obtenerDatos()
  }         
  

  obtenerDatos(){
    this.ingresoService.obtenerIngresos().subscribe({
      next: (data)=>{       
        this.listaIngreso$ =  data.response;
        this.listaIngreso = data.response;
      },    
      error: (error)=> {
        console.error("Los datos del servidor no llegan");
        console.log(error);     
      },
      complete: ()=>{
        console.log("Complete")
      }
  }); 

  
  }

  /*============================================================*/
  
  // METODOS CRUD
  
  /*-------GUARDAR NUEVO INGRESO----------------*/

  guardarIngreso(){    
    const nuevoIngreso = this.addIngresoForm.value;
    console.log("NUEVO INGRESO:")
    console.log(nuevoIngreso);
    // Reseteando el Formulario
    this.addIngresoForm = this.formBuilder.group(
      {      
        fecha: [''],
        tipo: [''],
        importe:[''],
        descripcion:[''],
        monedaId:1,
        esIncluida:true
      }
    )
    // Servicio Ingreso Service 
    this.ingresoService.guardarIngreso(nuevoIngreso).subscribe(
      (data)=>{},
      (error) => {
        alert("Algo ha fallado: " + error);
      },
      ()=>{
        this.obtenerDatos();
        console.log("Ingreso creado");
        location.reload();
      }
    ) 
  }

  /*-------EDITAR INGRESO-----------------------*/

  editableId(id:number,incomes:any){
    const editableIngreso = incomes;
    this.editId = id;
    console.log(id);
    console.log(incomes);
  
  // Cargar datos en el modal
    this.editIngresoForm.controls['fecha'].setValue(editableIngreso.fecha);
    this.editIngresoForm.controls['tipo'].setValue(editableIngreso.categoria);
    this.editIngresoForm.controls['importe'].setValue(editableIngreso.importe);
    this.editIngresoForm.controls['descripcion'].setValue(editableIngreso.descripcion);
  }
  actualizarIngreso(){
    const nuevoIngreso = this.editIngresoForm.value;
    console.log(nuevoIngreso);
    this.editIngresoForm.reset();
    const editId = this.editId;
    this.ingresoService.actualizarIngreso(editId,nuevoIngreso,this.httpOptions).subscribe(
      data=>{},
      (error) => {
        alert("Algo ha fallado: " + error);
      },
      ()=>{
        this.obtenerDatos();
        this.recargar=this.recargar+1;
        location.reload();
      }
    )
  }

  /*-------ELIMINAR INGRESO-----------------------*/

  trashId(id:number):void{
    this.borrarId = id;   
    console.log(this.borrarId);
  }
  eliminarIngreso(): void{
    this.ingresoService.borrarIngreso(this.borrarId).subscribe(
      data=>{},
      (error) => {
        alert("Algo ha fallado: " + error);
      },
      ()=>{
        this.obtenerDatos();
        this.recargar=this.recargar+1;
        location.reload();
      }
    )
  }

  /*============================================================*/

  // BOTONES DE PAGINACION
  nextPage(){
    this.page = this.page +10;
  }
  previusPage(){
    this.page = this.page -10;
  }

  /*============================================================*/

  // METODOS DE ORDENAMIENTO - (Recibiendo Input)
  recibirOrden(mensaje:string){
    this.orden = mensaje;
    this.page=0
  }

  /*============================================================*/

  // VALIDATORS

  // Propiedades para los validadores

  // Propiedades Guardar Ingreso
  get FechaAdd() { 
    return this.addIngresoForm.get('fecha'); 
  }
  get CategoriaAdd() {
    return this.addIngresoForm.get('tipo')
  }
  get ImporteAdd() { 
    return this.addIngresoForm.get('importe'); 
  }
  get DescripcionAdd() {
    return this.addIngresoForm.get('descripcion')
  }
  clearValidatorsAdd() {
    const hoy = this.fechaService.actual();
    this.addIngresoForm.controls['fecha'].setValue(hoy);
  }
  // Propiedades Editar Ingreso
  get FechaEdit() { 
    return this.editIngresoForm.get('fecha'); 
  }
  get CategoriaEdit() {
    return this.editIngresoForm.get('tipo')
  }
  get ImporteEdit() { 
    return this.editIngresoForm.get('importe'); 
  }
  get DescripcionEdit() {
    return this.editIngresoForm.get('descripcion')
  }
  clearValidatorsEdit() {
    this.editIngresoForm.reset(this.editIngresoForm.value);
  }

  // Navegacion
  scrollTo() {
    window.location.hash = '';
    window.location.hash = "tiburon";   
  }

  /*----------Funciones Auxiliares----------*/
  
  // Invertir Fecha
  invertir(miFecha:string){
    const parte = miFecha.split("-", 3);
    const nuevaFecha = parte[2]+"-"+parte[1]+"-"+parte[0]
    return nuevaFecha
  }
  // Recargar
  recargate(){
    this.recargar=this.recargar+1;
  }

  filtrar(){
    console.log("Filtro ejecutado")
  }
  restablecer(){
    console.log("Restableciendo valores")
  }
}
