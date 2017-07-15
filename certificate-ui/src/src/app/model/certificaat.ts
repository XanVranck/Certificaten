export interface Certificaat{
    certificaatId:number;
    certificaatNummer:string;
    certificaatDatum:Date;
    specifiekTonnage:number;
}

export class CertificaatClass implements Certificaat {
    certificaatId:number;    
    certificaatNummer:string;
    certificaatDatum:Date;
    specifiekTonnage:number;

    constructor(certificaatId: number, certificaatNummer:string, certificaatDatum:Date, specifiekTonnage:number){
        this.certificaatId = certificaatId;
        this.certificaatNummer = certificaatNummer;
        this.certificaatDatum = certificaatDatum;
        this.specifiekTonnage = specifiekTonnage;
    }

}