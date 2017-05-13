import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs/Observable";
import { Klant } from "../model/klant";
import {promise} from "selenium-webdriver";
import map = promise.map;

@Injectable()
export class KlantService{
    private _klantUrl: string;
    
    constructor(private _http:Http){
        this._klantUrl = `${environment.baseUrl}/klant`;
    }

    getKlanten():Observable<Array<Klant>>{
        return this._http
                    .get(`${environment.baseUrl}/klant`)
                    .map((response:Response)=> response.json())                    
    }

    addKlant(klant:Klant){
        console.log("klantservice add klant")
        this._http
            .post(this._klantUrl, klant)
    }
}