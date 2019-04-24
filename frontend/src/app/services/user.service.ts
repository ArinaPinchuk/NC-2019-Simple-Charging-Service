import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../modules/models/product";
import {User} from "../modules/models/user";
import {Role} from "../modules/models/role";

@Injectable()
// Data service
export class UserService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for billing account data
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/user');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user', user);
  }

  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>('/api/user/' + userId);
  }
  getUserById(id: string): Observable<User> {
    return this.http.get<User>('/api/user/' + id);
  }
}
