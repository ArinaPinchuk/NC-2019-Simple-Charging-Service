import {Injectable} from '@angular/core';
import {ValidationErrors} from '@angular/forms';
import {Observable, Subscription} from "rxjs";
import {delay, subscribeOn} from "rxjs/operators";
import {User} from "../models/user";
import {UserService} from "./user.service";

@Injectable()
export class UserValidationService {
  private users: User[];
  private logins: string[];
  subscriptions: Subscription[] = [];

  constructor(private userService: UserService) {
    this.logins = ['john', 'ivan', 'anna'];

  }

  validateLogin(userName: string, users: User[]): Observable<ValidationErrors> {
    /** Эмуляция запроса на сервер */
    return new Observable<ValidationErrors>(observer => {
      this.subscriptions.push(this.userService.getUsers().subscribe(users => {
        this.users = users;
        const user = this.users.find(user => user.login === userName);
        /** если пользователь есть в массиве, то возвращаем ошибку */
        if (user) {
          observer.next({
            nameError: 'Пользователь с таким именем уже существует'
          });
          observer.complete();
        }
        /** Если пользователя нет, то валидация успешна */
        observer.next(null);
        observer.complete();
      }));
    }).pipe(
      delay(1000)
    );
  }


}
