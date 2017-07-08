export interface Certificaat{
    certificaatNummer:string;
    certificaatDatum:string;
    specifiekTonnage:number;
}

export class CertificaatClass implements Certificaat {
    certificaatNummer:string;
    certificaatDatum:string;
    specifiekTonnage:number;

    constructor(certificaatNummer:string, certificaatDatum:string, specifiekTonnage:number){
        this.certificaatNummer = certificaatNummer;
        this.certificaatDatum = certificaatDatum;
        this.specifiekTonnage = specifiekTonnage;
    }

}