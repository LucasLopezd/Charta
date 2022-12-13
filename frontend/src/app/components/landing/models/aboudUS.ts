import { R } from "chart.js/dist/chunks/helpers.core";

export class AboudUs{
    id: number;
    nameComplete: string;
    role: string;
    description: string;
    image: string;
    linKedIn: string;
    behance: string;
    github: string;
    email: string;


    constructor(id: number, nameComplete: string, role: string, description: string, image: string, linKedIn: string, behance: string, github: string, email: string){
        this.id = id;
        this.nameComplete = nameComplete;
        this.role = role;
        this.description = description;
        this.image = image;
        this.linKedIn = linKedIn;
        this.behance = behance;
        this.github = github;
        this.email = email;
        }
}

