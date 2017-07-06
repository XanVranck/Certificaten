export interface Klant{
    klantId:string;
    naam:string;
}

export class KlantClass implements Klant {
    klantId:string;
    naam: string;

    constructor(klantId:string, naam:string){
        this.klantId = klantId;
        this.naam = naam;
    }

}