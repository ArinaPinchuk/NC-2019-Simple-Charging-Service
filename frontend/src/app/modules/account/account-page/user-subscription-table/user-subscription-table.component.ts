import { Component, OnInit } from '@angular/core';
import {AccountService} from "../../../../services/account.service";
import {Subscription_} from "../../../../models/subscription";

@Component({
  selector: 'app-user-subscription-table',
  templateUrl: './user-subscription-table.component.html',
  styleUrls: ['../account-page.component.css']
})
export class UserSubscriptionTableComponent implements OnInit {

  constructor(private accountService: AccountService) { }

  ngOnInit() {
  }
  unsubscribe(subscription: Subscription_){
    this.accountService.unsubscribe(subscription);
  }

}
