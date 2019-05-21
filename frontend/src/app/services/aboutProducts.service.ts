import {Injectable} from "@angular/core";
import {Product} from "../models/product";
import {ProductService} from "./product.service";

@Injectable()
export class AboutProductsService
{
  products: Product[];
  ready_products: boolean=false;
  constructor(private productService: ProductService){}

  loadProducts() {
      this.ready_products=false;

      this.productService.getProducts().subscribe(products => {
        this.products = products;
        this.ready_products = true;
      })
    }


}
