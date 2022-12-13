export class Gasto {
    fecha: Date;
    categoria: string;
    descripcion:string;
    importe:number;

    constructor(fecha: Date, categoria:string, descripcion:string, importe:number) {
        this.fecha = fecha;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.importe = importe;
    }
}