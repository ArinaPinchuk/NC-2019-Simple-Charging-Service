import { Pipe, PipeTransform } from '@angular/core';
import {Product} from "../models/product";
import {ProductService} from "./product.service";
import {interval, Observable} from "rxjs";
import {promise} from "selenium-webdriver";
import delayed = promise.delayed;

@Pipe({
  name: 'productTextFilter'
})
export class ProductTextFilterPipe implements PipeTransform {
  constructor(private productService: ProductService){}

  transform(products: Product[], text: string): any {
    if(text==null|| text=="")
      return products;
   let newProducts: Product[];
    /*return products.filter(p=> p.name.startsWith(text));*/
   return this.productService.startWith(text).subscribe(p=>
    {
      newProducts=p;
      return newProducts;
    });

   // return newProducts;
  }


}
