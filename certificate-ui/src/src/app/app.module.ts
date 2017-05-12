import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpModule, Http} from '@angular/http';
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import {RouterModule} from '@angular/router';

import { AppComponent } from './app.component';
import { klantenComponent } from './klanten/klanten.component';
import {routes} from './app.routes';


@NgModule({
  declarations: [
    AppComponent,
    klantenComponent
  ],
    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
        ReactiveFormsModule,
        RouterModule.forRoot(routes)
    ],
  providers: [],
  bootstrap: [klantenComponent]
})
export class AppModule { }
