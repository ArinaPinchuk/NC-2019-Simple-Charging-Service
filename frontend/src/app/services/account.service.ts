import {Injectable, TemplateRef} from "@angular/core";
import {User} from "../models/user";
import {Subscription_} from "../models/subscription";
import {Subscription} from "rxjs";
import {UserService} from "./user.service";
import {Wallet} from "../models/wallet";
import {Product} from "../models/product";
import {ProductService} from "./product.service";
import {SubscriptionService} from "./subscription.service";
import {WalletService} from "./wallet.service";

@Injectable()
export class AccountService
{
  user: User;
  user_subscriptions: Subscription_[];
  subscriptions: Subscription[]=[];
  subscriptions2: Subscription[]=[];
  product_subscr: Subscription[]=[];
  subscr_subscr: Subscription[]=[];
  ready: boolean=false;
  ready_prod: boolean=false;
  ready_subscriptions: boolean=false;
  hasWallet: boolean = false;
  isAdmin: boolean =false;
  isSubscribed: boolean[]=[];
  products: Product[];
  users: Set<User>=new Set();
  all_subscriptions: Map<User, Subscription_[]> = new Map();
  subs: any;
  constructor(private userService: UserService, private productService: ProductService,
              private subscriptionService: SubscriptionService, private walletService: WalletService){}

  loadData(login: string)
  {

    this.subscriptions.push(this.userService.getUserByLogin(login).subscribe(u=>{
        this.user=u;
        this.ready=true;
        if(this.user.walletsByWalletId)
        {
          this.hasWallet=true;
        }
        if(this.user.roleByRoleId.roleId==1) {
          this.isAdmin = true;
          this.allSubscriptions();
        }
        else this.userSubscriptions();
      }));
  }
  loadProducts()
  {
    this.product_subscr.push(this.productService.getProducts().subscribe(p=>{
        this.products=p;
        this.ready_prod=true;
        var j:number=0;
        var i:number=0;
        if(!this.isAdmin) {
          for (j = 0; j < this.products.length; j++)
            for(i = 0; i < this.user_subscriptions.length; i++)
              if(this.products[j].productId==this.user_subscriptions[i].productsByProductId.productId)
                this.isSubscribed[j]=true;
        }

      }));
  }

  addFunds(sum: number) {
    this.user.walletsByWalletId.balance+=sum;
    this.subscriptions.push(this.walletService.saveWallet(this.user.walletsByWalletId).subscribe(() => {
    }));
    if(this.user.statusByStatusId.statusId==2 && this.user.walletsByWalletId.balance>0)
    {
      this.user.statusByStatusId.statusId=1;
      this.user.statusByStatusId.statusName="active";
      this.subscriptions.push(this.userService.addWallet(this.user).subscribe());
    }
  }
  userSubscriptions()
  {
    this.subscr_subscr.push(this.subscriptionService.getSubscriptionsByUserId(this.user.userId).subscribe(s=>{
      this.user_subscriptions=s;
      this.ready_subscriptions=true;
      this.loadProducts();

    }));
  }
  allSubscriptions()
  {
    this.subscriptions2.push(this.userService.getUsersByRoleId(2).subscribe(u=>
    {
      for(let i=0; i<u.length; i++)
      {
        this.subscr_subscr.push(this.subscriptionService.getSubscriptionsByUserId(u[i].userId).subscribe(s=>{
          this.all_subscriptions.set(u[i], s);
        }));
      }
      this.loadProducts();
      this.ready_subscriptions=true
    }));
  }
  loadAllUsers()
  {
    if(this.user_subscriptions)
    {
      for(var i=0; i<this.user_subscriptions.length; i++ )
        this.users.add(this.user_subscriptions[i].usersByUserId);
    }
  }
  createWallet()
  {
    var wallet=new Wallet();
    wallet.balance=10;
    this.subscriptions.push(this.walletService.saveWallet(wallet).subscribe( w => {
      wallet = w;
      this.user.walletsByWalletId=wallet;
      this.subscriptions.push(this.userService.addWallet(this.user).subscribe(() => {
        this.hasWallet=true;
      }));
    }));

  }
  addSubscription(product:Product, i:number, days: number)
  {
    let subscr: Subscription_=new Subscription_();
    subscr.productsByProductId=product;
    subscr.usersByUserId=this.user;
    subscr.date=new Date();
    subscr.days=days;
    this.subscriptions.push(this.subscriptionService.saveSubscription(subscr).subscribe(() => {
      this.subscr_subscr.push(this.subscriptionService.getSubscriptionsByUserId(this.user.userId).subscribe(s=>{
        this.user_subscriptions=s;
        this.isSubscribed[i]=true;
      }));
    }));
  }
  blockUser(user:User)
  {
    user.statusByStatusId.statusId=2;
    this.subscriptions.push(this.userService.blockUser(user).subscribe(u=>{
    }));

  }
  getUserSubscriptions(user: User): Subscription_[]
  {
    var subs: Subscription_[];
    this.subscr_subscr.push(this.subscriptionService.getSubscriptionsByUserId(user.userId).subscribe(s=>{
      subs=s;
    }));
    return subs;
  }
  unsubscribe(subscr: Subscription_)
  {
    this.subscr_subscr.push(this.subscriptionService.deleteSubscription(subscr.subscriptionId.toString()).subscribe(()=>{
      this.subscriptions.push(this.subscriptionService.getSubscriptionsByUserId(this.user.userId).subscribe(s=>{
        this.user_subscriptions=s;
        let i: number=Number(subscr.productsByProductId.productId);
        this.isSubscribed[i-1]=false;
      }));

    }));
  }
  logOut()
  {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
    this.subscriptions2.forEach(subscription => subscription.unsubscribe());
    this.subscr_subscr.forEach(subscription => subscription.unsubscribe());
    this.product_subscr.forEach(subscription => subscription.unsubscribe());

  }

}
