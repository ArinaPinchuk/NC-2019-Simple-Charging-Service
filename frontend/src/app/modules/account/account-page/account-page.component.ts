import {Component, OnInit, TemplateRef} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {RoleService} from "../../../services/role.service";
import {Role} from "../../models/role";
import {ProductService} from "../../../services/product.service";
import {Product} from "../../models/product";
import {Observable} from "rxjs";
import {UserService} from "../../../services/user.service";
import {User} from "../../models/user";
import {WalletService} from "../../../services/wallet.service";
import {BsModalService} from "ngx-bootstrap";
import {SubscriptionService} from "../../../services/subscription.service";
import {Subscription_} from "../../models/subscription";
import {Wallet} from "../../models/wallet";
import {resetComponentState} from "@angular/core/src/render3/state";


@Component({
  selector: 'app-account-page',
  templateUrl: './account-page.component.html',
  styleUrls: ['./account-page.component.css']
})
export class AccountPageComponent implements OnInit {
  isAdmin: boolean=false;
  user: User;
  users: Set<User>=new Set();
  products: Product[];
  user_subscriptions: Subscription_[];
  private subscriptions: Subscription[] = [];
  private product_subscr: Subscription[] = [];
  private subscr_subscr: Subscription[] = [];
  isSubscribed: boolean[]=[];
  wallet: Wallet;
  ready: boolean = false;
  ready_prod: boolean=false;
  ready_subscriptions: boolean=false;
  hasWallet: boolean=false;
  sum:number=1;

  constructor(private roleService: RoleService,
              private productService: ProductService,
              private userService: UserService,
              private subscriptionService: SubscriptionService,
              private activateRoute: ActivatedRoute,
              private router: Router,
              private walletService: WalletService,
              private modalService: BsModalService) {
  }

  ngOnInit() {
    const login = this.activateRoute.snapshot.params['login'];
    this.load(login);

  }
  load(login:string)
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
      },
      error=>{
        this.router.navigate(['/error'], {});
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

      },
      error => {
        this.router.navigate(['/error'], {});
      }));
  }
  showModal(template: TemplateRef<any>)
  {
    this.modalService.show(template);
    this.sum=5;
  }

  addFunds() {
    this.user.walletsByWalletId.balance+=this.sum;
    this.subscriptions.push(this.walletService.saveWallet(this.user.walletsByWalletId).subscribe(() => {
    }));
    this.sum=5;
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
    this.subscr_subscr.push(this.subscriptionService.getSubscriptions().subscribe(s=>{
      this.user_subscriptions=s;
      this.ready_subscriptions=true;
      this.loadProducts();
      this.loadAllUsers();
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
    this.wallet=new Wallet();
    this.wallet.balance=0;
    this.subscriptions.push(this.walletService.saveWallet(this.wallet).subscribe( w => {
      this.wallet = w;
      this.user.walletsByWalletId=this.wallet;
      this.subscriptions.push(this.userService.addWallet(this.user).subscribe(() => {
        this.hasWallet=true;
      }));
    }));
    /*resetComponentState();*/

  }
  addSubscription(product:Product, i:number)
  {
    var subscr: Subscription_=new Subscription_();
    subscr.productsByProductId=product;
    subscr.usersByUserId=this.user;
    subscr.date=new Date(2018, 9, 12,12,12,12,12);
    this.subscriptions.push(this.subscriptionService.saveSubscription(subscr).subscribe(() => {
    }));
    this.user_subscriptions.push(subscr);
    this.isSubscribed[i]=true;
  }
  blockUser(user:User)
  {
    this.subscriptions.push(this.userService.blockUser(user).subscribe(() => {
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

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
    this.product_subscr.forEach(subscription=>subscription.unsubscribe());
  }
}
