export class Movimiento {
    fecha: Date;
    categoria: string;
    descripcion:string;
    importe:number;
    tipo:string;

    constructor(fecha: Date, categoria:string, descripcion:string, importe:number, tipo:string) {
        this.fecha = fecha;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.importe = importe;
        this.tipo = tipo;
    }
}