import { Component, OnInit } from '@angular/core';
import {Http} from "@angular/http";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-dummy',
  template: `
<p>
{{text}}
</p>
`
})
export class DummyComponent implements OnInit {

  text: string = "test";

  constructor(private http:Http) { }

  ngOnInit() {
    this.http.get(`${environment.baseUrl}/dummy`).subscribe(
      txt => this.text = txt.text()
    );
  }

}
