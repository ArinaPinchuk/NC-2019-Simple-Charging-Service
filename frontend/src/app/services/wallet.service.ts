import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Wallet} from "../modules/models/wallet";

@Injectable()
// Data service
export class WalletService { //todo create interface

  constructor(private http: HttpClient) {
  }
  saveWallet(wallet: Wallet): Observable<Wallet> {
    return this.http.post<Wallet>('/api/wallet', wallet);
  }
}
