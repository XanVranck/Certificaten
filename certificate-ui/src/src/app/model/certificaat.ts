export interface Certificaat{
    certificaatNummer:string;
    certificaatDatum:Date;
    specifiekTonnage:number;
}

export class CertificaatClass implements Certificaat {
    certificaatNummer:string;
    certificaatDatum:Date;
    specifiekTonnage:number;

    constructor(certificaatNummer:string, certificaatDatum:Date, specifiekTonnage:number){
        this.certificaatNummer = certificaatNummer;
        this.certificaatDatum = certificaatDatum;
        this.specifiekTonnage = specifiekTonnage;
    }

}