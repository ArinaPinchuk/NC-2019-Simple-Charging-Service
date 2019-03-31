import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private _router: Router){}

  ngOnInit() {
  }
  clickFunc(): void {
    this._router.navigate(['/account']);
  }

}
