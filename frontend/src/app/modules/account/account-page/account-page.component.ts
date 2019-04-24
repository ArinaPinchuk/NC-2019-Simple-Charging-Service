import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {RoleService} from "../../../services/role.service";
import {Role} from "../../models/role";
import {ProductService} from "../../../services/product.service";
import {Product} from "../../models/product";
import {Observable} from "rxjs";

@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {

  isTableSubscr: boolean = false;
  isTableServices: boolean = false;
  role: Role;
  products: Product[];
  private subscriptions: Subscription[] = [];
  private product_subscr: Subscription[] = [];
  ready: boolean = false;
  ready_prod: boolean=true;

  constructor(private roleService: RoleService,
              private productService: ProductService,
              private activateRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    const id = this.activateRoute.snapshot.params['id'];
    this.subscriptions.push(this.roleService.getRole().subscribe(r => {
        this.role = r[0];
        this.ready = true;
      },
      error => {
        this.router.navigate(['/error'], {});
      }));
    this.product_subscr.push(this.productService.getProducts().subscribe(p=>{
      this.products=p;
      this.ready_prod=true;
    },
      error => {
        this.router.navigate(['/error'], {});
      }));

  }

  showTableSubscr() {
    this.isTableSubscr = !this.isTableSubscr;
  }

  showTableServices() {
    this.isTableServices = !this.isTableServices;
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
    this.product_subscr.forEach(subscription=>subscription.unsubscribe());
  }
}
