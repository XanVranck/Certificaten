import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs/Observable";
import { Klant } from "../model/klant";
import {KlantClass} from '../model/klant'
import {Adres} from '../model/adres'
import {promise} from "selenium-webdriver";
import map = promise.map;
import 'rxjs/Rx';

@Injectable()
export class KlantService{
    private _klantUrl: string;
    private _klant:Klant;
    private _adres:Adres;
    
    constructor(private _http:Http){
        this._klantUrl = `${environment.baseUrl}/klant`;
    }

    getKlanten():Observable<Array<Klant>>{
        return this._http
                    .get(this._klantUrl)
                    .map((response:Response)=> response.json())                    
    }

    addKlant(naam:string, straat:string, nummer:string, postCode:string, stad:string){
        this._klant = { 
                        "naam":naam,
                        "straat":straat,
                        "nummer":nummer,
                        "postCode":postCode,
                        "stad":stad
                    }
        return this._http
            .post(this._klantUrl, this._klant)    
    }
}