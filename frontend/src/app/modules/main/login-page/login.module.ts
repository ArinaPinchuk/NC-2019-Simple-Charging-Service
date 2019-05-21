import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {LoginPageComponent} from "./login-page.component";
import {AuthService} from "../../../services/auth.service";
import {TokenStorage} from "../../../services/token.storage";
import {MenuComponent} from "../menu/menu.component";



@NgModule({
  declarations: [
    LoginPageComponent,
    MenuComponent,

  ],
  imports: [
    FormsModule,
    BrowserModule,
    RouterModule,
    HttpClientModule,
  ],
  providers: [AuthService, TokenStorage/*,{provide: HTTP_INTERCEPTORS,
    useClass: Interceptor,
    multi : true}*/,
    /*CookieService*/],
  exports: [LoginPageComponent, MenuComponent]

})
export class LoginModule {
}
