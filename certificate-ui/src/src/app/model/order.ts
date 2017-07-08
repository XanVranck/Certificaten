export interface Order{
    orderId:number,
    werkOrderNummer:string;
    aankoopOrderNummer:string;
    specificatie:string;
    totaal:number;
    klantNaam:String;
}

export class OrderIdClass implements Order {
    orderId:number;
    werkOrderNummer:string;
    aankoopOrderNummer:string;
    specificatie:string;
    totaal:number;
    klantNaam:String;

    constructor(orderId: number, werkOrderNummer:string, aankoopOrderNummer:string, specificatie:string, totaal:number, klantNaam:String){
        this.orderId = orderId;
        this.werkOrderNummer = werkOrderNummer;
        this.aankoopOrderNummer = aankoopOrderNummer;
        this.specificatie = specificatie;
        this.totaal = totaal;
        this.klantNaam = klantNaam;
    }
}