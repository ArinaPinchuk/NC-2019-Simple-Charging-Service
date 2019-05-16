import {Component, OnInit, TemplateRef} from '@angular/core';
import {Subscription} from "rxjs";
import {User} from "../../../../models/user";
import {ProductService} from "../../../../services/product.service";
import {Product} from "../../../../models/product";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../../../services/user.service";
import {Subscription_} from "../../../../models/subscription";
import {SubscriptionService} from "../../../../services/subscription.service";
import {AccountService} from "../../../../services/account.service";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['../account-page.component.css']
})
export class ProductTableComponent implements OnInit  {
  days: number;
  product: Product;
  num: number;
  page: number=0;
  pages: Array<number>;
  products: Array<any>;
  ready: boolean=false;
  pageSize: number;
  constructor(public accountService: AccountService, private productService: ProductService,
              private modalService: BsModalService, private _bsModalRef: BsModalRef) { }
  addSubscription(){
    this.accountService.addSubscription(this.product, this.num, this.days);
    this._bsModalRef.hide();
  }
  openModal(template: TemplateRef<any>, product: Product, i: number)
  {
    this.product=product;
    this.num=i;
    this.modalService.show(template);
  }
  closeModal()
  {
    this.modalService.hide(1);
  }
  getPages()
  {
    this.productService.getPage(this.page).subscribe(data=>
    {
      this.products=data['content'];
      this.pages=new Array(data['totalPages']);
      this.pageSize = data['size'];
      this.ready=true;
    })
  }
  setPage(i:number, event:any)
  {
    this.page=i;
    this.getPages();
    event.preventDefault();
  }

  ngOnInit(): void {
    this.getPages();
  }

}
