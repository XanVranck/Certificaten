import {Component, OnInit} from '@angular/core';
import { Klant, KlantClass } from "../model/klant";
import {KlantService} from "../service/klant.service";
import {Router} from "@angular/router";

@Component({
    selector: 'klanten',
    template: `
        <div class="wrapper">
            <h2>Choose existing customer</h2>
            <form class="ccform">
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-users fa-2x"></i></span>
                 <input list="customers" name="klant" [(ngModel)]="klant" placeholder="Klanten" class="ccformfield" required>
                     <dataList id="customers" >
                        <option id="kl" *ngFor="let klant of klanten" ng-change="selectKlant(klant)" value="{{klant.naam}}">{{klant.id}}</option>
                    </dataList>                  
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" (click)="goToOrders(klant)" value="Bekijk order(s)">
                </div>
            </form>


            <h2>Add customer</h2>
            <form class="ccform">
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-user-plus fa-2x"></i></span>
                    <input #naamKl class="ccformfield" type="text" placeholder="Naam" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-id-card-o fa-2x"></i></span>
                    <input #straatKl class="ccformfield" type="text" placeholder="Straat" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-sort-numeric-asc fa-2x"></i></span>
                    <input #nummerKl class="ccformfield" type="text" placeholder="Huisnummer" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-info fa-2x"></i></span>
                    <input #postCodeKl class="ccformfield" type="text" placeholder="Postcode" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-building fa-2x"></i></span>
                    <input #stadKl class="ccformfield" type="text" placeholder="Stad" required>
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" (click)="addKlant(naamKl.value, straatKl.value, nummerKl.value, postCodeKl.value, stadKl.value)" value="Voeg klant toe">
                </div>
            </form>
        </div>
    `
})

export class klantenComponent implements OnInit {
    private _klant:Klant;
    private _klantId:number;
    private selectedKlant: number;
    private _klanten: Array<Klant>;
    private _naam: string;
    private _straat:string;
    private _nummer:string;
    private _postCode:string;
    private _stad:string;

    constructor(private router: Router, private _klantService: KlantService){
        this._klanten = [];
        this.selectedKlant=undefined;
    }

    selectKlant(klant:Klant){
        //this.selectedKlant = (<HTMLInputElement>document.getElementById("customers")).toString();
        
        localStorage.setItem("klantId", klant.klantId.toString());
        localStorage.setItem("Klant", klant.naam)
    }

    deselectKlant(){
        this.selectedKlant = null;
    }

    goToOrders(klant:Klant){

        //console.log("klantOrder", this.selectedKlant);            
        console.log("id", localStorage.getItem("klantId"))
        console.log("klant", localStorage.getItem("Klant"))
        console.log("gotToOrdersKlant", klant.naam)
        console.log("goToOrdersKlantId", klant.klantId)
       // console.log((<HTMLInputElement>document.getElementById("kl")))
       // this.router.navigate(['./order']);             
    }

    addKlant(naam:string, straat:string, nummer:string, postCode:string, stad:string){
       if(naam !== "" && straat !== "" && nummer !== "" && postCode !== "" && stad !== ""){
        this._klantService
            .addKlant(naam, straat, nummer, postCode, stad)
            .subscribe();
            alert("klant opgeslagen!")
       }
        this.ngOnInit();
    }

    get klanten():Array<Klant>{
        console.log("klanten", this._klanten)                        
        return this._klanten
    }

    ngOnInit(){
        this._klantService
            .getKlanten()
            .subscribe(klant => this._klanten = klant)
    }
}
