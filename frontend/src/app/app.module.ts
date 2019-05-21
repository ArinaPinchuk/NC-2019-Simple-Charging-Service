import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {HomePageComponent} from './modules/main/home-page/home-page.component';
import {RouterModule} from "@angular/router";
import {SignupPageComponent} from './modules/main/signup-page/signup-page.component';
import {LoginPageComponent} from './modules/main/login-page/login-page.component';
import {ServicesPageComponent} from './modules/main/services-page/services-page.component';
import {AccountPageComponent} from './modules/account/account-page/account-page.component';
import {ModalModule} from "ngx-bootstrap";
import {AccountModule} from "./modules/account/account-page/account.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Interceptor} from "./services/interceptor";
import {TokenStorage} from "./services/token.storage";
import {AuthService} from "./services/auth.service";
import {LoginModule} from "./modules/main/login-page/login.module";
import {UserValidationService} from "./services/userValidation.service";
import {AuthGuard} from "./auth.guard";
import { AboutProductsPageComponent } from './modules/main/about-products-page/about-products-page.component';
import {AboutProductsService} from "./services/aboutProducts.service";
import { ProductTextFilterPipe } from './services/product-text-filter.pipe';
import {ProductService} from "./services/product.service";


const routes = [{path: '', component: HomePageComponent},
  {path: 'signup', component: SignupPageComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'services', component: ServicesPageComponent},
  {path: 'services/:index', component: AboutProductsPageComponent},
  {path: 'account/:login', component: AccountPageComponent, canActivate: [AuthGuard]},
]

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    SignupPageComponent,
    ServicesPageComponent,
    AboutProductsPageComponent,
    ProductTextFilterPipe,
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AccountModule,
    LoginModule,
    ModalModule.forRoot(),
    RouterModule.forRoot(routes),

  ],


  providers: [AuthService, ProductService, UserValidationService, TokenStorage, {
    provide: HTTP_INTERCEPTORS,
    useClass: Interceptor,
    multi: true
  },
    AuthGuard, AboutProductsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
