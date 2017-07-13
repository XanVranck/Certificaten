import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs/Observable";
import { Order } from "../model/order";
import {OrderIdClass} from '../model/order'
import {promise} from "selenium-webdriver";
import {Router} from "@angular/router";
import map = promise.map;
import 'rxjs/Rx';

@Injectable()
export class OrderService{
    private _orderUrl:string;
    private _order:OrderIdClass;
    private _klantNaam:String;
    private _exceptionThrown:boolean;
    
    constructor(private _http:Http, private router:Router){
        this._orderUrl = `${environment.baseUrl}/order`;
        this._exceptionThrown = false;
    }

    getOrders(klantNaam:string):Observable<Array<Order>>{
         let header = new Headers({'Accept' : 'application/json'});
        this._klantNaam = klantNaam;
        return this._http
                    .get(this._orderUrl + "/" + klantNaam, { headers: header })
                    .map((response:Response)=> response.json()) 
                    ._catch((err) => {
                        const details = {
                            detail:err.json(), status :err.status
                        };
                        this._exceptionThrown = true;                        
                        alert(details.detail.message); 
                        if(this._exceptionThrown === true){
                            this.router.navigate(['./klanten'])
                        }    
                        this._exceptionThrown = false;                        
                                       
                        return Observable.throw(details);
                    })             
    }

    addOrder(werkOrderNummer:string, aankoopOrderNummer:string, specificatie:string, totaal:number, klantNaam:string){
        this._order = { 
                        "orderId" : 0,
                        "werkOrderNummer":werkOrderNummer,
                        "aankoopOrderNummer":aankoopOrderNummer,
                        "specificatie":specificatie,
                        "totaal":totaal,
                        "klantNaam":klantNaam
                    }
        return this._http
            .post(this._orderUrl, this._order)    
    }
}