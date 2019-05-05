import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {RouterModule} from '@angular/router';
import {RoleService} from "../../../services/role.service";
import {AccountPageComponent} from "./account-page.component";
import {AccountMenuComponent} from "../account-menu/account-menu.component";
import {ProductService} from "../../../services/product.service";
import {UserService} from "../../../services/user.service";
import {WalletService} from "../../../services/wallet.service";
import {FormsModule} from "@angular/forms";
import {SubscriptionService} from "../../../services/subscription.service";

@NgModule({
  declarations: [
    AccountPageComponent,
    AccountMenuComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    RouterModule,
    HttpClientModule,
  ],
  providers: [RoleService, ProductService, UserService, WalletService, SubscriptionService],
  exports: [AccountPageComponent, AccountMenuComponent]
})
export class RoleModule {
}
