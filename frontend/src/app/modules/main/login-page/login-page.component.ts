import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthService} from "../../../services/auth.service";
import {TokenStorage} from "../../../services/token.storage";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private _router: Router, private authService: AuthService, private token: TokenStorage) {
  }

  ngOnInit() {
  }
  clickLogin(username:string, password:string): void {
    this.authService.attemptAuth(username, password).subscribe(
      data => {
        this.token.signOut();
        this.token.saveToken(data.token, username);
        this._router.navigate(['account', username]);
      }
    );
  }
}
