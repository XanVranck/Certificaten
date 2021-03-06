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
                 <input #kl list="customers" name="klant"  placeholder="Klanten" class="ccformfield" required>
                     <dataList id="customers" >
                        <option id="kl" (ngModel)="klanten" *ngFor="let klant of klanten" value="{{klant.naam}}"></option>
                    </dataList>                  
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" (click)="goToOrders(kl.value)" value="Bekijk order(s)">
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

            <h2>Delete customer</h2>
            <form class="ccform">
                <div class="ccfield-prepend">
                    <span class="ccform-addon"><i class="fa fa-user-times fa-2x"></i></span>
                <input #klToDelete list="customers" name="klant" class="ccformfield" placeholder="klanten" required>
                    <dataList id="customers" >
                        <option id="klToDelete" (ngModel)="klanten" *ngFor="let klant of klanten" value="{{klant.naam}}">{{klant.klantId}}</option>
                    </dataList>  
                </div>
                <div class="ccfield-prepend">
                    <input class="ccbtn" type="submit" (click)="deleteKlant(klToDelete.value)" value="Verwijder klant">
                </div>
            </form>
        </div>
    `
})

export class klantenComponent implements OnInit {
    private _klanten: Array<Klant>;

    constructor(private router: Router, private _klantService: KlantService){
        this._klanten = [];
    }

    goToOrders(klantNaam:string){
    if(klantNaam !== ""){
        localStorage.setItem("klantNaam", klantNaam)
       this.router.navigate(['./orders']);   
    }else{
        alert("Geen klant geselecteerd...")
    }
    }

    addKlant(naam:string){
       if(naam !== ""){
        this._klantService
            .addKlant(naam)
            .subscribe(() =>{
                alert("Klant opgeslagen!"),  this.ngOnInit()
            });
            
       }
       this.ngOnInit();        
    }

    deleteKlant(naam:string){
        if(naam !== ""){
            this._klantService
                .deleteKlant(naam)
                .subscribe(() =>{
                    alert(naam + " zit niet meer in de databank"), this.ngOnInit()
                });
        }
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
