import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs/Observable";
import { Klant } from "../model/klant";
import {KlantClass} from '../model/klant'
import {promise} from "selenium-webdriver";
import {RequestOptions} from '@angular/http';
import map = promise.map;
import 'rxjs/Rx';

@Injectable()
export class KlantService{
    private _klantUrl: string;
    private _klant:KlantClass;
    
    constructor(private _http:Http){
        this._klantUrl = `${environment.baseUrl}/klant`;
    }

    getKlanten():Observable<Array<Klant>>{
        return this._http
                    .get(this._klantUrl)
                    .map((response:Response)=> response.json())        
    }

    addKlant(naam:string){
        this._klant = { 
                        "klantId":undefined,
                        "naam":naam
                    }
        return this._http
                    .post(this._klantUrl, this._klant)    
    }

    deleteKlant(naam:string){
        this._klant = { 
                        "klantId":undefined,
                        "naam":naam
                    }
        return this._http
                    .delete(this._klantUrl, 
                    new RequestOptions({
                        body:this._klant
                    }))
                     ._catch((err) => {
                        const details = {
                            detail:err.json(), status :err.status
                        };
                                              
                        alert(details.detail.message);                    
                                       
                        return Observable.throw(details);
                    })             
    }
}