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
             <th *ngIf="getIsActive()">order ID</th>            
             <th>Workorder nr</th>
             <th>Purchase order nr</th>
             <th>Specification</th>
             <th>Estimated</th>
         </tr>
     </thead>
     <tbody>
         <tr style="cursor:pointer" *ngFor="let order of orders" (click)="goToCertificaten(order)">
            <td *ngIf="getIsActive()">
             <div class="radiotext">
                      <label style="cursor:pointer">{{order.orderId}}</label>
             </div>
             </td>
             <td>
             <div class="radiotext">
                      <label style="cursor:pointer">{{order.werkOrderNummer}}</label>
             </div>
             </td>
            <td>
             <div class="radiotext">
                 <label style="cursor:pointer">{{order.aankoopOrderNummer}}</label>
             </div>
             </td>
              <td>
             <div class="radiotext">
                 <label style="cursor:pointer">{{order.specificatie}}</label>
             </div>
             </td>
             <td>
             <div class="radiotext">
                 <label style="cursor:pointer">{{order.totaal}}</label>
             </div>
             </td>
         </tr>
         <br>
         <br>
         
            <form action="">
                <input type="checkBox" name="update" value="Update order" (change)="setIsActive()">Update an order
            </form>
         </tbody>
</table>
    
    
    <div *ngIf="!getIsActive()">
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
            <input #orderTot class="ccformfield" type="number" placeholder="Total estimated" required>
        </div>
        <div class="ccfield-prepend">
            <input class="ccbtn" type="submit" (click)="addOrder(orderWON.value, orderPON.value, orderSpec.value, orderTot.value)" value="Submit">
        </div>
        <div class="ccfield-prepend">
            <input class="ccbtn" type="submit" (click)="terugNaarKlanten()" value="Terug naar klanten">
        </div>
        </form>
    </div>

    <div *ngIf="getIsActive()">
        <h2>Update an order</h2>
        <form class="ccform">
        <div class="ccfield-prepend">
            <span class="ccform-addon"><i class="fa fa-id-card fa-2x"></i></span>
            <input #orderID class="ccformfield" type="number" placeholder="order ID" required>
        </div>
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
            <input #orderTot class="ccformfield" type="number" placeholder="Total estimated" required>
        </div>
        <div class="ccfield-prepend">
            <input class="ccbtn" type="submit" (click)="updateOrder(orderID.value, orderWON.value, orderPON.value, orderSpec.value, orderTot.value)" value="Submit">
        </div>
        <div class="ccfield-prepend">
            <input class="ccbtn" type="submit" (click)="terugNaarKlanten()" value="Terug naar klanten">
        </div>
        </form>
    </div>
</div>
`
})

export class ordersComponent implements OnInit {
    private _orders:Array<Order>
    private _isActive:boolean;

    constructor(private _orderService:OrderService, private router: Router){
        this._orders = []
        this._isActive = false;
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
       if(werkOrderNummer   !== "" && aankoopOrderNummer   !== "" && specificatie   !== "" && totaal !== undefined){
        this._orderService
            .addOrder(werkOrderNummer, aankoopOrderNummer, specificatie, totaal, localStorage.getItem("klantNaam"))
            .subscribe(() =>{
                alert("Order opgeslagen!"),  this.ngOnInit()
            });
       }     
    }

    goToCertificaten(order:OrderIdClass){
        localStorage.setItem("order", JSON.stringify(order))
        this.router.navigate(['./certificaten'])    
    }

    updateOrder(orderId:number, werkOrderNummer:string, aankoopOrderNummer:string, specificatie:string, totaal:number){
    if(orderId !== undefined && werkOrderNummer   !== "" && aankoopOrderNummer   !== "" && specificatie   !== "" && totaal !== undefined){
        this._orderService
            .updateOrder(orderId, werkOrderNummer, aankoopOrderNummer, specificatie, totaal)
            .subscribe(()=>{
                alert("Order aangepast!"),  this.ngOnInit();
            });
                
    }
    };

    terugNaarKlanten(){
        this.router.navigate(['./klanten'])
    }

    setIsActive(){
        this._isActive = !this._isActive;
    }

    getIsActive(){
        return this._isActive
    }
}