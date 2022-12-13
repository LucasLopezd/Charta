export class ResGastos {
    amount:number;
    categoryColorCode:string;
    categoryIcon:string;
    categoryName:string;
    codeCurrency:string;
    date:string;
    deleted:boolean;
    description:string;
    id:number;
    isIncluded:boolean;

    constructor(isIncluded:boolean,deleted:boolean,categoryIcon:string,categoryColorCode:string,date:string,codeCurrency: string, category:string, description:string, amount:number, id:number) {
        this.date = date;
        this.categoryName = category;
        this.description = description;
        this.amount = amount;
        this.id = id;
        this.isIncluded= isIncluded;
        this.categoryColorCode= categoryColorCode;
        this.categoryIcon= categoryIcon;
        this.codeCurrency= codeCurrency;
        this.deleted= deleted;
    }
}