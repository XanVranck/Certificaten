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
                    <input class="ccbtn" type="submit" (click)="addKlant(naamKl.value)" value="Voeg klant toe">
                </div>
            </form>
        </div>
    `
})

export class klantenComponent implements OnInit {
    private _klant:Klant;
    private _klantId:number;
    private _klanten: Array<Klant>;
    private _naam: string;

    constructor(private router: Router, private _klantService: KlantService){
        this._klanten = [];
    }

    goToOrders(klant:Klant){
       this.router.navigate(['./orders']);             
    }

    addKlant(naam:string){
       if(naam !== ""){
        this._klantService
            .addKlant(naam)
            .subscribe();
            alert("klant opgeslagen!")
       }
        this.ngOnInit();
    }

    get klanten():Array<Klant>{                   
        return this._klanten
    }

    ngOnInit(){
        this._klantService
            .getKlanten()
            .subscribe(klant => this._klanten = klant)
    }
}
