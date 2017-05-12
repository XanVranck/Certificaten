export interface Klant{
    id:number;
    naam:string;
    straat:string;
    nummer:string;
    postCode:string;
    stad:string;
}

export class KlantClass implements Klant {
    id: number;
    naam: string;
    straat: string;
    nummer: string;
    postCode: string;
    stad: string;
    
    constructor(naam:string, straat:string, nummer:string, postCode:string, stad:string){
        this.id = undefined;
        this.naam = naam;
        this.straat = straat;
        this.nummer = nummer
        this.postCode = postCode;
        this.stad = stad;
    }

}