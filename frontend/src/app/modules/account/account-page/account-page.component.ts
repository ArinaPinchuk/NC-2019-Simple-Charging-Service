import {Component, OnInit, TemplateRef} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {BsModalService} from "ngx-bootstrap";
import {Wallet} from "../../../models/wallet";
import {AccountService} from "../../../services/account.service";


@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {
  wallet: Wallet;
  sum:number=1;

  constructor(
              private activateRoute: ActivatedRoute,
              private router: Router,
              private modalService: BsModalService,
              public accountService: AccountService
              ) {
  }

  ngOnInit() {
    const login = this.activateRoute.snapshot.params['login'];
    this.accountService.loadData(login);

  }
  logOut()
  {
    this.accountService.logOut();
    this.router.navigate(['']);
  }

}
