import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {RoleService} from "../../../services/role.service";
import {AccountPageComponent} from "./account-page.component";
import {AccountMenuComponent} from "../account-menu/account-menu.component";
import {ProductService} from "../../../services/product.service";

@NgModule({
  declarations: [
   AccountPageComponent,
    AccountMenuComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    HttpClientModule,
  ],
  providers: [RoleService, ProductService],
  exports: [AccountPageComponent, AccountMenuComponent]
})
export class RoleModule {
}
