export class Prueba {    
    categoria:string;
    categoriaColor:string;
    categoriaIcono:string;
    deleted:boolean;
    descripcion:string;
    esIncluida:boolean;
    fecha:string;
    id:number;
    importe:number;
    monedaCodigo:string;

    constructor(fecha: string, categoria:string, categoriaColor:string, categoriaIcono:string,descripcion:string, importe:number, deleted:boolean, esIncluida:boolean, id:number, monedaCodigo:string) {
        this.fecha = fecha;
        this.categoriaColor = categoriaColor;
        this.categoriaIcono = categoriaIcono;
        this.deleted= deleted;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.importe = importe;
        this.id = id;
        this.esIncluida = esIncluida;
        this.monedaCodigo= monedaCodigo;
    }
}