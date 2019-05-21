import {User} from "./user";
import {Product} from "./product";

export class Subscription_ {
  date: Date;
  subscriptionId: number;
  usersByUserId: User;
  productsByProductId: Product;
  days: number;
}
