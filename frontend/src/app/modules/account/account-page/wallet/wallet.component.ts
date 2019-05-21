import {Component, OnInit, TemplateRef} from '@angular/core';
import {BsModalService} from "ngx-bootstrap";
import {AccountService} from "../../../../services/account.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['../account-page.component.css']
})
export class WalletComponent implements OnInit {
  sum: number = 5;
  cardTypes:string[] = ['Visa', 'Mastercard'];
  cardNumber: string;
  cardType: string ="Visa";
  walletReactiveForm: FormGroup;

  constructor(private modalService: BsModalService, public accountService: AccountService, private fb: FormBuilder) {
  }

  ngOnInit() {
    this.walletReactiveForm = this.fb.group({
      cardType: ['', [
        Validators.required,
      ]],
      cardNumber: ['', [
        Validators.required,
        Validators.minLength(5)
      ]]});
  }

  showModal(template: TemplateRef<any>) {
    this.modalService.show(template);
    this.sum = 5;
  }

  addFunds() {
    if (this.sum > 0) {
      this.accountService.addFunds(this.sum);
      this.sum = 5;
      this.modalService.hide(1);
      document.body.classList.remove('modal-open');
    }
  }
  createWallet()
  {
    const controls = this.walletReactiveForm.controls;
    if (this.walletReactiveForm.invalid) {
      Object.keys(controls)
        .forEach(controlName => controls[controlName].markAsTouched());
      return;
    }
      this.accountService.createWallet(this.walletReactiveForm.value.cardType, this.walletReactiveForm.value.cardNumber);
      this.modalService.hide(1);
      document.body.classList.remove('modal-open');
  }

}
