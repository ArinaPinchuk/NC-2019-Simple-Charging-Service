import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalService} from "ngx-bootstrap";
import {AccountService} from "../../../../services/account.service";

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['../account-page.component.css']
})
export class WalletComponent implements OnInit {
  sum: number = 5;

  constructor(private modalService: BsModalService, public accountService: AccountService) { }

  ngOnInit() {
  }

  showModal(template: TemplateRef<any>)
  {
    this.modalService.show(template);
    this.sum=5;
  }

  addFunds() {
    if (this.sum > 0) {
      this.accountService.addFunds(this.sum);
      this.sum = 5;
      this.modalService.hide(1);
    }
  }
}
