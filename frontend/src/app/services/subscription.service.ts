import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../models/role";
import {Subscription_} from "../models/subscription";
import {User} from "../models/user";

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

  deleteSubscription(subscriptionId: string): Observable<void> {
    return this.http.delete<void>('/api/subscription/' + subscriptionId);
  }

}
