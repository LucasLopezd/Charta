import { Prueba } from "./prueba";

export class ResPrueba {    
    response:Array<Prueba>;
    status:string;
    timestamp:string;


    constructor(response:Array<Prueba>,status:string,timestamp:string) {
        this.response = response;
        this.status = status;
        this.timestamp = timestamp;
    }
}