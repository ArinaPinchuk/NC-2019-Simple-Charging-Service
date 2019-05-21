import {Component, OnInit} from '@angular/core';
import {Subscription_} from "../../../../models/subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs";
import {SubscriptionService} from "../../../../services/subscription.service";
import {UserService} from "../../../../services/user.service";
import {User} from "../../../../models/user";
import {AccountService} from "../../../../services/account.service";
import {subscribeOn} from "rxjs/operators";

@Component({
  selector: 'app-subscription-table',
  templateUrl: './subscription-table.component.html',
  styleUrls: ['../account-page.component.css']
})
export class SubscriptionTableComponent implements OnInit {
  subscr: any;


  constructor(private router: Router, private activateRoute: ActivatedRoute,
              public accountService: AccountService) {


  }

  ngOnInit() {
    this.subscr = this.accountService.all_subscriptions.entries();
  }

  blockUser(user: User) {
    this.accountService.blockUser(user)
  }

  ready(): boolean {
    if (this.accountService.ready_subscriptions) {
      this.subscr = this.accountService.all_subscriptions.entries();
    }

    return this.accountService.ready_subscriptions;
  }

}
