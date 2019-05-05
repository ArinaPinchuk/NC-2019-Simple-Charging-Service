import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../modules/models/role";
import {Subscription_} from "../modules/models/subscription";
import {User} from "../modules/models/user";

@Injectable()
// Data service
export class SubscriptionService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getSubscriptions(): Observable<Subscription_[]> {
    return this.http.get<Subscription_[]>('/api/subscription');
  }

  getSubscriptionsByUserId(userId: number): Observable<Subscription_[]> {
    return this.http.get<Subscription_[]>('/api/subscription/userId/' + userId);
  }
  saveSubscription(subscription: Subscription_): Observable<Subscription_> {
    return this.http.post<Subscription_>('/api/subscription', subscription);
  }

}
