import { Component } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-root',
  template: `
<h1>
  {{ 'TITLE' | translate:{catchPhrase:'Hoooooooo!'} }}
</h1>

<button (click)="changeLanguage('nl')">NL</button>/<button (click)="changeLanguage('fr')">FR</button>

<app-dummy></app-dummy>
`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private translate: TranslateService) {
    // this language will be used as a fallback when a translation isn't found in the current language
    translate.setDefaultLang('en');

    // the lang to use, if the lang isn't available, it will use the current loader to get them
    translate.use('nl');
  }

  changeLanguage(newLanguage: string) {
    this.translate.use(newLanguage);
  }
}
