import {Component, OnInit} from '@angular/core';
import { Certificaat, CertificaatClass } from "../model/certificaat";
import {CertificaatService} from '../service/certificaat.service'
import {Order, OrderIdClass} from "../model/order";
import { DatePipe } from '@angular/common'

import {Router} from "@angular/router";

@Component({
    selector: 'certificaten',
    template: `<div class="wrapper">
<h2>Existing certificates</h2>
    <table class="ccform">
     <thead>
         <tr>
             <th *ngIf="getIsActive()">certificaat ID</th>            
             <th>Certificate nr</th>
             <th>Date certificate</th>
             <th>Tonnage</th>
         </tr>
     </thead>
     <tbody>
         <tr  *ngFor="let certificaat of certificaten">
            <td *ngIf="getIsActive()">
             <div class="radiotext">
                      <label style="cursor:pointer">{{certificaat.certificaatId }}</label>
             </div>
             </td>
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

         <br>
         <br>

        <form action="">
            <input type="checkBox" name="update" value="Update certificate" (change)="setIsActive()">Update an certificate
        </form>
           
         </tbody>
</table>
    
    
    <div *ngIf="!getIsActive()">
        <h2>Add new certificate</h2>
        <form class="ccform">
        <div class="ccfield-prepend">
            <span class="ccform-addon"><i class="fa fa-certificate fa-2x"></i></span>
            <input #certificaatNr class="ccformfield" type="text" placeholder="Certificate nr" required>
        </div>
        <div class="ccfield-prepend">
            <span class="ccform-addon"><i class="fa fa-calendar-check-o fa-2x"></i></span>
            <input #certificaatDate class="ccformfield" type="date" required>
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

    <div *ngIf="getIsActive()">
        <h2>Update certificate</h2>
        <form class="ccform">
        <div class="ccfield-prepend">
            <span class="ccform-addon"><i class="fa fa-id-card fa-2x"></i></span>
            <input #certificaatId class="ccformfield" type="number" placeholder="Certificate id" required>
        </div>
        <div class="ccfield-prepend">
            <span class="ccform-addon"><i class="fa fa-certificate fa-2x"></i></span>
            <input #certificaatNr class="ccformfield" type="text" placeholder="Certificate nr" required>
        </div>
        <div class="ccfield-prepend">
            <span class="ccform-addon"><i class="fa fa-calendar-check-o fa-2x"></i></span>
            <input #certificaatDate class="ccformfield" type="date" required>
        </div>
        <div class="ccfield-prepend">
            <span class="ccform-addon"><i class="fa fa-balance-scale fa-2x"></i></span>
            <input #certificaatTon class="ccformfield" type="number" name="quantity" min="1" placeholder="Tonnage" required>
        </div>
        <div class="ccfield-prepend">
            <input class="ccbtn" type="submit" (click)="updateCertificaat(certificaatId.value, certificaatNr.value, certificaatDate.value, certificaatTon.value)" value="Submit">
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
</div>
`
})
export class certificatenComponent implements OnInit {

    private _certificaten:Array<Certificaat>
    private _order:OrderIdClass
    private _orderId:number;
    private _certificaat:CertificaatClass;
    private date:Date;
    private _isActive:boolean;

    constructor(private router: Router, private _certificaatService:CertificaatService, private datepipe: DatePipe){
        this._certificaten = []
        this.date = new Date;
        this._isActive = false;
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

    addCertificaat(certificaatNummer:string, certificaatDatum:Date, specifiekTonnage:number){
        
    this._certificaat = {
        "certificaatId" : undefined,
        "certificaatNummer": certificaatNummer,
        "certificaatDatum" : certificaatDatum,
        "specifiekTonnage" : specifiekTonnage
    }

    if(certificaatNummer !== "" && (specifiekTonnage !== null || specifiekTonnage !==0) && certificaatDatum !== undefined){
        this._certificaatService
            .addCertificaat(this._certificaat, this._orderId)
            .subscribe(() =>{
                alert("Certificaat opgeslagen!"),  this.ngOnInit()
            });
        }
    }

    updateCertificaat(certificaatId:number, certificaatNummer:string, certificaatDatum:Date, specifiekTonnage:number){
        
    this._certificaat = {
        "certificaatId" : certificaatId,
        "certificaatNummer": certificaatNummer,
        "certificaatDatum" : certificaatDatum,
        "specifiekTonnage" : specifiekTonnage
    }

    if(certificaatId !== undefined && certificaatNummer !== "" && (specifiekTonnage !== null || specifiekTonnage !==0) && certificaatDatum !== undefined){
        this._certificaatService
            .updateCertificaat(this._certificaat)
            .subscribe(() =>{
                alert("Certificaat aangepast!"),  this.ngOnInit()
            });
        }
    }

    terugNaarOrders(){
      this.router.navigate(['./orders'])
    }
    terugNaarKlanten(){
      this.router.navigate(['./klanten'])        
    }

    getDate(){
        let latest_date = this.datepipe.transform(this.date, 'dd-MM-yyyy')
        return latest_date;
    }

     setIsActive(){
        this._isActive = !this._isActive
    }

    getIsActive(){
        return this._isActive
    }
}