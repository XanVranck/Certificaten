import { Injectable } from "@angular/core";
import { Http, Response, Headers } from "@angular/http";
import { environment } from "../../environments/environment";
import { Observable } from "rxjs/Observable";
import { Certificaat } from "../model/certificaat";
import {CertificaatClass} from '../model/certificaat'
import {promise} from "selenium-webdriver";
import map = promise.map;
import 'rxjs/Rx';

@Injectable()
export class CertificaatService{
    private _certificaatUrl:string;
    private _certificaat:CertificaatClass;
    
    constructor(private _http:Http){
        this._certificaatUrl = `${environment.baseUrl}/certificaat`;
    }

    getCertificaten(orderId:number):Observable<Array<Certificaat>>{
        let header = new Headers({'Accept' : 'application/json'});
        return this._http
                    .get(this._certificaatUrl + "/" + orderId, { headers: header })
                    .map((response:Response)=> response.json())           
    }

    addCertificaat(certificaat:CertificaatClass, orderId:number){
         return this._http
            .post(this._certificaatUrl, certificaat)    
    }

    updateCertificaat(certificaat:CertificaatClass){
        return this._http
                .put(this._certificaatUrl, this._certificaat)

    }
}