import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../../services/product.service";
import {Subscription} from "rxjs";
import {Product} from "../../../models/product";
import {Router} from "@angular/router";

@Component({
  selector: 'app-services-page',
  templateUrl: './services-page.component.html',
  styleUrls: ['./services-page.component.css']
})
export class ServicesPageComponent implements OnInit {
  isMore: boolean[] = [];
  private product_subscr: Subscription[] = [];
  products: Product[];
  ready: boolean = false;

  constructor(private productService: ProductService,
              private router: Router) {
  }

  ngOnInit() {
    this.product_subscr.push(this.productService.getProducts().subscribe(res => {
        this.products = res;
        this.ready = true;
      }));

  }

  public _onSearch($event): void {
    this.productService.startWith($event.target.value).subscribe(foundProducts => {
      this.products = foundProducts;
    });

  }

  showMore(i: number) {
    this.router.navigate(['services', i]);
   // window.open(url, "_blank");
    /*this.isMore[i] = !this.isMore[i];*/
  }


}
