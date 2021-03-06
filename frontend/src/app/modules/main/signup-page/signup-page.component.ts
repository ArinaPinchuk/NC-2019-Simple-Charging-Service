import {Component, OnInit} from '@angular/core';
import {User} from "../../../models/user";
import {UserService} from "../../../services/user.service";
import {Observable, Subscription} from "rxjs";
import {Role} from "../../../models/role";
import {RoleService} from "../../../services/role.service";
import {Wallet} from "../../../models/wallet";
import {FormBuilder, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {UserValidationService} from "../../../services/userValidation.service";
import {Router} from "@angular/router";
import {TokenStorage} from "../../../services/token.storage";
import {AuthService} from "../../../services/auth.service";


@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {
  public newUser: User = new User();
  private subscriptions: Subscription[] = [];
  role: string;
  wallet: Wallet = new Wallet();
  userReactiveForm: FormGroup;
  users: User[];
  userTypes: string[];
  ready: boolean;

  constructor(private userService: UserService, private roleService: RoleService, private fb: FormBuilder,
              private userValidationService: UserValidationService, private _router: Router, private token: TokenStorage, private authService: AuthService) {
  }

  ngOnInit() {

    this.userTypes = ['admin', 'user'];
    this.initForm();
    this.subscriptions.push(this.userService.getUsers().subscribe(users => {
      this.users = users;
      this.ready = true;

    }));
  }

  initForm() {
    this.userReactiveForm = this.fb.group({
      firstName: ['', [
        Validators.required,
        Validators.pattern(/^[A-z0-9]*$/),
        Validators.minLength(3)
      ]],
      secondName: ['', [
        Validators.required,
        Validators.pattern(/^[A-z0-9]*$/),
        Validators.minLength(3)
      ]],
      email: ['', [
        Validators.required, Validators.email
      ]],
      login: ['', [
        Validators.required,
        Validators.pattern(/^[A-z0-9]*$/),
        Validators.minLength(3)
      ],
        [this.loginAsyncValidator.bind(this)]],
      password: [null, [
        Validators.required,
        this.passwordValidator]
      ],
      role: [null, [Validators.required]],

    });
  }

  onSubmit() {
    const controls = this.userReactiveForm.controls;
    if (this.userReactiveForm.invalid) {
      Object.keys(controls)
        .forEach(controlName => controls[controlName].markAsTouched());
      return;
    }
    let user: User = new User();
    user.firstName = this.userReactiveForm.value.firstName;
    user.secondName = this.userReactiveForm.value.secondName;
    user.email = this.userReactiveForm.value.email;
    user.login = this.userReactiveForm.value.login;
    user.password = this.userReactiveForm.value.password;
    if (this.userReactiveForm.value.role === "admin")
      user.roleByRoleId = new Role(1);
    else user.roleByRoleId = new Role(2);
    this.subscriptions.push(this.userService.registerUser(user).subscribe(() => {
      this.authService.attemptAuth(user.login, user.password).subscribe(
        data => {
          this.token.signOut();
          this.token.saveToken(data.token, user.login);
          this._router.navigate(['account', user.login]);
        }
      );
    }));
    console.log(this.userReactiveForm.value);
  }


  isControlInvalid(controlName: string): boolean {
    const control = this.userReactiveForm.controls[controlName];

    const result = control.invalid && control.touched;

    return result;
  }


  loginAsyncValidator(control: FormControl): Observable<ValidationErrors> {
    return this.userValidationService.validateLogin(control.value, this.users);
  }

  public addUser() {
    if (this.role == "1")
      this.newUser.roleByRoleId = new Role(1);
    else this.newUser.roleByRoleId = new Role(2);
    this.subscriptions.push(this.userService.saveUser(this.newUser).subscribe(() => {
    }));
  }

  private passwordValidator(control: FormControl): ValidationErrors {
    const value = control.value;
    const hasNumber = /[0-9]/.test(value);
    const hasCapitalLetter = /[A-Z]/.test(value);
    const hasLowercaseLetter = /[a-z]/.test(value);
    const isLengthValid = value ? value.length > 7 : false;
    const passwordValid = hasNumber && hasCapitalLetter && hasLowercaseLetter && isLengthValid;

    if (!passwordValid) {
      return {invalidPassword: 'Invalid password, use numbers, capitals, lowers, length > 7'};
    }
    return null;
  }

}

