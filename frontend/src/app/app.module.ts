import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { HomePageComponent } from './modules/main/home-page/home-page.component';
import {RouterModule} from "@angular/router";
import { SignupPageComponent } from './modules/main/signup-page/signup-page.component';
import { LoginPageComponent } from './modules/main/login-page/login-page.component';
import { ServicesPageComponent } from './modules/main/services-page/services-page.component';
import { AccountPageComponent } from './modules/account/account-page/account-page.component';
import {EWalletPageComponent} from "./modules/account/e-wallet-page/e-wallet-page.component";
import { MenuComponent } from './modules/main/menu/menu.component';
import { AccountMenuComponent } from './modules/account/account-menu/account-menu.component';
import {TestComponent} from "./modules/main/test/test.component";
import {ModalModule} from "ngx-bootstrap";
import { LoginModalComponent } from './modules/main/login-modal/login-modal.component';




const routes=[{path:'', component: HomePageComponent},
  {path:'signup', component: SignupPageComponent},
  {path:'login', component: LoginPageComponent},
  {path:'services', component: ServicesPageComponent},
  {path:'account', component: AccountPageComponent},
  {path:'test', component: TestComponent},
  {path:'eWallet', component: EWalletPageComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    SignupPageComponent,
    TestComponent,
    LoginPageComponent,
    ServicesPageComponent,
    AccountPageComponent,
    MenuComponent,
    EWalletPageComponent,
    AccountMenuComponent,
    LoginModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ModalModule.forRoot(),
    RouterModule.forRoot(routes)
  ],

  exports: [
    LoginModalComponent
  ],
  entryComponents: [LoginModalComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
