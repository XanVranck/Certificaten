import {Component, OnInit} from '@angular/core';
import { Certificaat, CertificaatClass } from "../model/certificaat";
import {CertificaatService} from '../service/certificaat.service'
import {Order, OrderIdClass} from "../model/order";

import {Router} from "@angular/router";

@Component({
    selector: 'certificaten',
    template: `<div class="wrapper">
<h2>Existing certificates</h2>
    <table class="ccform">
     <thead>
         <tr>
             <th>Certificate nr</th>
             <th>Date certificate</th>
             <th>Tonnage</th>
         </tr>
     </thead>
     <tbody>
         <tr  *ngFor="let certificaat of certificaten">
             <td>
             <div class="radiotext">
                 <label for='Certificatenr1'>{{certificaat.certificaatNummer}}</label>
             </div>
             </td>
            <td>
             <div class="radiotext">
                 <label for='Certificatenr1'>{{certificaat.certificaatDatum}}</label>
             </div>
             </td>
              <td>
             <div class="radiotext">
                 <label for='Certificatenr1'>{{certificaat.specifiekTonnage}}</label>
             </div>
             </td>
         </tr>
         
           
         </tbody>
</table>
    
    
    
	<h2>Add new certificate</h2>
    <form class="ccform">
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-certificate fa-2x"></i></span>
        <input #certificaatNr class="ccformfield" type="text" placeholder="Certificate nr" required>
    </div>
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-calendar-check-o fa-2x"></i></span>
        <input #certificaatDate class="ccformfield" type="text" placeholder="Date certificate" required>
    </div>
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-balance-scale fa-2x"></i></span>
        <input #certificaatTon class="ccformfield" type="number" name="quantity" min="1" placeholder="Tonnage" required>
    </div>
    <div class="ccfield-prepend">
        <input class="ccbtn" type="submit" (click)="addCertificaat(certificaatNr.value, certificaatDate.value, certificaatTon.value)" value="Submit">
    </div>

    </form>
    <form class="ccform">    
    <div class="ccfield-prepend">
        <input class="ccbtn" type="submit" (click)="terugNaarOrders()" value="Terug naar orders">      
    </div>
    <div class="ccfield-prepend">
        <input class="ccbtn" type="submit" (click)="terugNaarKlanten()" value="Terug naar klanten">        
    </div>
    </form>
</div>
`
})
export class certificatenComponent implements OnInit {

    private _certificaten:Array<Certificaat>
    private _order:OrderIdClass
    private _orderId:number;
    private _certificaat:CertificaatClass;

    constructor(private router: Router, private _certificaatService:CertificaatService){
        this._certificaten = []
    }

    ngOnInit(): void {
        var cert = localStorage.getItem("order")
        this._order = JSON.parse(cert)
        this._orderId = this._order.orderId;
    
        this._certificaatService
            .getCertificaten(this._orderId)
            .subscribe(certificaat => this._certificaten = certificaat)
    }

    get certificaten():Array<Certificaat>{                   
        return this._certificaten
    }

    addCertificaat(certificaatNummer:string, certificaatDatum:string, specifiekTonnage:number){
    this._certificaat = {
        "certificaatNummer": certificaatNummer,
        "certificaatDatum" : certificaatDatum,
        "specifiekTonnage" : specifiekTonnage
    }

    if(certificaatNummer !== "" && certificaatDatum !== ""){
        this._certificaatService
            .addCertificaat(this._certificaat, this._orderId)
            .subscribe(() =>{
                alert("Certificaat opgeslagen!"),  this.ngOnInit()
            });
        }
    }

    terugNaarOrders(){
      this.router.navigate(['./orders'])
    }
    terugNaarKlanten(){
      this.router.navigate(['./klanten'])        
    }
}