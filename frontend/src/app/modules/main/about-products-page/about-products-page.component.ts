import { Component, OnInit } from '@angular/core';
import {AboutProductsService} from "../../../services/aboutProducts.service";
import {Product} from "../../../models/product";
import {ActivatedRoute} from "@angular/router";
import {ProductService} from "../../../services/product.service";

@Component({
  selector: 'app-about-products-page',
  templateUrl: './about-products-page.component.html',
  styleUrls: ['./about-products-page.component.css']
})
export class AboutProductsPageComponent implements OnInit {
  product: Product;
  ready: boolean=false;

  constructor(private aboutProductsService: AboutProductsService,  private activateRoute: ActivatedRoute, private productService: ProductService) {
  }

  ngOnInit() {
    const index = this.activateRoute.snapshot.params['index'];
    this.productService.getProductById(index).subscribe(product=>{
      this.product=product;
      this.ready=true;
    }
  )
  }

}
