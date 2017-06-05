import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {HttpModule} from '@angular/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FormControl,FormGroup} from '@angular/forms';
import {NgModule} from '@angular/core';
import {HashLocationStrategy, LocationStrategy} from '@angular/common';

import {AppComponent} from './app.component';
import {ordersComponent} from './orders/orders.component'
import { klantenComponent } from './klanten/klanten.component';
import {KlantService} from './service/klant.service';
import {routes} from './app.routes';



@NgModule({
    bootstrap: [AppComponent],
    declarations: [
        AppComponent,
        klantenComponent,
        ordersComponent,
    ],
    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
        ReactiveFormsModule,
        RouterModule.forRoot(routes)
    ],
    providers: [
       KlantService,
        {provide: LocationStrategy, useClass: HashLocationStrategy}
    ]
    })
export class BootModule {
}
