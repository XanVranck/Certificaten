import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs/Observable";
import { Order } from "../model/order";
import {OrderIdClass} from '../model/order'
import {promise} from "selenium-webdriver";
import map = promise.map;
import 'rxjs/Rx';

@Injectable()
export class OrderService{
    private _orderUrl:string;
    private _order:OrderIdClass;
    private _klantNaam:String;
    
    constructor(private _http:Http){
        this._orderUrl = `${environment.baseUrl}/order`;
    }

    getOrders(klantNaam:string):Observable<Array<Order>>{
         let header = new Headers({'Accept' : 'application/json'});
        this._klantNaam = klantNaam;
        return this._http
                    .get(this._orderUrl + "/" + klantNaam, { headers: header })
                    .map((response:Response)=> response.json())           
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