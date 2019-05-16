import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../models/product";

@Injectable()
// Data service
export class ProductService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('/api/product');
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>('/api/product', product);
  }

  deleteProduct(productId: string): Observable<void> {
    return this.http.delete<void>('/api/product/' + productId);
  }

  getProductById(id: string): Observable<Product> {
    return this.http.get<Product>('/api/product/' + id);
  }
  getPage(page:number)
  {
    return this.http.get('/api/product/page?page='+page);
  }

}
