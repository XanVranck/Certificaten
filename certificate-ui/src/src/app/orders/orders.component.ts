import {Router} from "@angular/router";
import {Component, OnInit} from '@angular/core';
import {Order} from "../model/order"
import {OrderIdClass} from "../model/order"
import {OrderService} from "../service/order.service";

@Component({
    selector: 'orders',
    template: `
<header class="ccheader">
    <h1>Orders</h1>	
</header>
<div class="wrapper">
<h2>Choose existing order</h2>
    <table class="ccform">
     <thead>
         <tr>
             <th>Workorder nr</th>
             <th>Purchase order nr</th>
             <th>Specification</th>
             <th>Estimated</th>
         </tr>
     </thead>
     <tbody>
         <tr style="cursor:pointer" *ngFor="let order of orders" (click)="goToCertificaten(order)">
             <td>
             <div class="radiotext">
                      <label style="cursor:pointer" for='workorder1'>{{order.werkOrderNummer}}</label>
             </div>
             </td>
            <td>
             <div class="radiotext">
                 <label style="cursor:pointer" for='workorder1'>{{order.aankoopOrderNummer}}</label>
             </div>
             </td>
              <td>
             <div class="radiotext">
                 <label style="cursor:pointer" for='workorder1'>{{order.specificatie}}</label>
             </div>
             </td>
             <td>
             <div class="radiotext">
                 <label style="cursor:pointer" for='workorder1'>{{order.totaal}}</label>
             </div>
             </td>
         </tr>
         
           
         </tbody>
</table>
    
    
    
	<h2>Add new order</h2>
    <form class="ccform">
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-plus-circle fa-2x"></i></span>
        <input #orderWON class="ccformfield" type="text" placeholder="Work order nr" required>
    </div>
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-tasks fa-2x"></i></span>
        <input #orderPON class="ccformfield" type="text" placeholder="Purchase order nr" required>
    </div>
    <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-server fa-2x"></i></span>
        <input #orderSpec class="ccformfield" type="text" placeholder="Specification" required>
    </div>
     <div class="ccfield-prepend">
        <span class="ccform-addon"><i class="fa fa-calculator fa-2x"></i></span>
        <input #orderTot class="ccformfield" type="text" placeholder="Total estimated" required>
    </div>
    <div class="ccfield-prepend">
        <input class="ccbtn" type="submit" (click)="addOrder(orderWON.value, orderPON.value, orderSpec.value, orderTot.value)" value="Submit">
    </div>
    <div class="ccfield-prepend">
        <input class="ccbtn" type="submit" (click)="terugNaarKlanten()" value="Terug naar klanten">
    </div>
    </form>

</div>
`
})

export class ordersComponent implements OnInit {
    private _orders:Array<Order>

    constructor(private _orderService:OrderService, private router: Router){
        this._orders = []
    }

    ngOnInit(){
        this._orderService
            .getOrders(localStorage.getItem("klantNaam"))
            .subscribe(order => this._orders = order)
    }

    get orders():Array<Order>{                   
        return this._orders
    }

    addOrder(werkOrderNummer:string, aankoopOrderNummer:string, specificatie:string, totaal:number){   
       if(werkOrderNummer   !== "" && aankoopOrderNummer   !== "" && specificatie   !== ""){
        this._orderService
            .addOrder(werkOrderNummer, aankoopOrderNummer, specificatie, totaal, localStorage.getItem("klantNaam"))
            .subscribe();
            alert("klant opgeslagen!")
       }
        this.ngOnInit();        
    }

    goToCertificaten(order:OrderIdClass){
        console.log("order", JSON.stringify(order))
        localStorage.setItem("order", JSON.stringify(order))
        this.router.navigate(['./certificaten'])    
    }

    terugNaarKlanten(){
        this.router.navigate(['./klanten'])
    }
}