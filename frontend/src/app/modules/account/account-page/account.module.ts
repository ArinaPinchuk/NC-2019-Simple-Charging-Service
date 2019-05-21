import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {BrowserModule} from '@angular/platform-browser';
import {ActivatedRouteSnapshot, RouterModule} from '@angular/router';
import {RoleService} from "../../../services/role.service";
import {AccountPageComponent} from "./account-page.component";
import {AccountMenuComponent} from "../account-menu/account-menu.component";
import {ProductService} from "../../../services/product.service";
import {UserService} from "../../../services/user.service";
import {WalletService} from "../../../services/wallet.service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SubscriptionService} from "../../../services/subscription.service";
import {SubscriptionTableComponent} from './subscription-table/subscription-table.component';
import {ProductTableComponent} from './product-table/product-table.component';
import {AccountService} from "../../../services/account.service";
import {UserSubscriptionTableComponent} from './user-subscription-table/user-subscription-table.component';
import {WalletComponent} from './wallet/wallet.component';
import {BsModalRef} from "ngx-bootstrap";

@NgModule({
  declarations: [
    AccountPageComponent,
    AccountMenuComponent,
    SubscriptionTableComponent,
    ProductTableComponent,
    UserSubscriptionTableComponent,
    WalletComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [RoleService, ProductService, UserService, WalletService, SubscriptionService, AccountService, BsModalRef],
  exports: [AccountPageComponent, AccountMenuComponent]
})
export class AccountModule {
}
