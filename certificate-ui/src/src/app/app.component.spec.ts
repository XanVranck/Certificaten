import {TestBed, async, getTestBed} from '@angular/core/testing';
import {TranslateModule, TranslateLoader, TranslateService} from '@ngx-translate/core';
import {Observable} from 'rxjs/Observable';

import {AppComponent} from './app.component';
import {DummyComponent} from "./dummy/dummy.component";
import {HttpModule, Http, BaseRequestOptions, XHRBackend} from "@angular/http";
import {MockBackend} from "@angular/http/testing";

class LocalTranslateLoader implements TranslateLoader {

  private translations: any = { "TITLE": "Fy Faen! {{catchPhrase}}" };

  getTranslation(lang: string): Observable<any> {
    return Observable.of(this.translations);
  }
}

describe('AppComponent', () => {
  let injector, translateService;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        DummyComponent
      ],
      imports: [
        TranslateModule.forRoot({
          loader: {
            provide: TranslateLoader,
            useFactory: () => new LocalTranslateLoader()
          }
        }),
        HttpModule
      ],
      providers: [
        MockBackend,
        BaseRequestOptions,
        {
          provide: Http,
          deps: [MockBackend, BaseRequestOptions],
          useFactory:
            (backend: XHRBackend, defaultOptions: BaseRequestOptions) => new Http(backend, defaultOptions)
        }
      ]
    }).compileComponents();
    injector = getTestBed();
    translateService = injector.get(TranslateService);
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should set default language to en', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    expect(translateService.getDefaultLang()).toBe('en');
  }));

  it('should use nl', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    expect(translateService.currentLang).toBe('nl');
  }));

  describe('changeLanguage', () => {
    it('should switch the language to the one passed as parameter', async(() => {
      const fixture = TestBed.createComponent(AppComponent);
      fixture.componentInstance.changeLanguage('fr');
      expect(translateService.currentLang).toBe('fr');
    }));
  });

  it('should have a translated title with params', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Fy Faen! Hoooooooo!');
  }));

});
