import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user";
import {UserService} from "../../../services/user.service";
import {Subscription} from "rxjs";
import {Role} from "../../models/role";
import {RoleService} from "../../../services/role.service";
import {Status} from "../../models/status";
import {Wallet} from "../../models/wallet";


@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {
  public newUser: User = new User();
  private subscriptions: Subscription[] = [];
  role: string;
  status: Status=new Status();
  wallet: Wallet = new Wallet();
  constructor(private userService: UserService, private roleService:RoleService) { }

  ngOnInit() {

  }
  public addUser()
  {
    if(this.role=="1")
      this.newUser.roleByRoleId=new Role(1);
    else this.newUser.roleByRoleId=new Role(2);


    this.subscriptions.push(this.userService.saveUser(this.newUser).subscribe(() => {
    }));
    /*this.role.roleName="AAA";
    this.subscriptions.push(this.roleService.saveRole(this.role).subscribe(() => {
    }));*/

  }

 /* ClickButton()
  {this.popup.show();}*/

}
