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
                 <input list="customers" name="klant" placeholder="Klanten" class="ccformfield" required>
                     <datalist id="customers">
                        <option *ngFor="let klant of klanten" (click)="selectKlant(klant)" value="{{klant.naam}}">{{klant.naam}}</option>
                    </datalist>                  
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" value="Submit">
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
                    <input class="ccbtn" type="submit" (click)="addKlant(naamKl.value, straatKl.value, nummerKl.value, postCodeKl.value, stadKl.value)" value="Submit">
                </div>
            </form>
        </div>
    `
})

export class klantenComponent implements OnInit {
    private _klant:Klant;
    private selectedKlant: Klant;
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
        this.selectedKlant = klant;
        //localStorage.setItem("klantID", klant.id);
        this.router.navigate(['./order']);
    }

    deselectKlant(){
        this.selectedKlant = null;
    }

    addKlant(naam:string, straat:string, nummer:string, postCode:string, stad:string){
        this._klant = new KlantClass(naam, straat, nummer, postCode, stad)
        this._klantService
            .addKlant(naam, straat, nummer, postCode, stad)
            .subscribe();
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
