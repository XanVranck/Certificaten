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
                    <input list="customers" name="customer" placeholder="Klanten" class="ccformfield" required>
                    <datalist id="customers">
                        <option *ngFor="let klant of _klanten" (click)="selectKlant(klant)" value="{{Klant.naam}}">
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
                    <input class="ccformfield" type="text" placeholder="Naam" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-id-card-o fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Straat" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-sort-numeric-asc fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Huisnummer" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-info fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Postcode" required>
                </div>
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-building fa-2x"></i></span>
                    <input class="ccformfield" type="text" placeholder="Stad" required>
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" value="Submit" (click)=addKlant(klant)>
                </div>
            </form>
        </div>
    `
})

export class klantenComponent {
    private _klant:Klant;
    private selectedKlant: Klant;
    private _klanten: Array<Klant>;
    private _klantService: KlantService;

    constructor(private router: Router){
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

    addKlant(klant:Klant){
        console.log("addKlant")
       // this._klant = new KlantClass(naam, straat, nummer, postCode, stad)
        this._klantService
            .addKlant(klant);

    }

    ngOnInit(){
        this._klantService
            .getKlanten()
            .subscribe(klanten => this._klanten = klanten);
            console.log("on init");
    }
}
