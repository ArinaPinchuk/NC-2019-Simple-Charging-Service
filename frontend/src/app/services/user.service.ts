import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../models/user";

@Injectable()
export class UserService { //todo create interface

  constructor(private http: HttpClient) {
  }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/user');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user', user);
  }

  addWallet(user: User): Observable<User> {
    return this.http.post<User>('/api/user/wallet', user);
  }

  blockUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user/block', user);
  }

  registerUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user/register', user);
  }

  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>('/api/user/' + userId);
  }

  getUserById(id: string): Observable<User> {
    return this.http.get<User>('/api/user/' + id);
  }

  getUserByLogin(login: string): Observable<User> {
    return this.http.get<User>('/api/user/login/' + login);
  }

  getUsersByRoleId(roleId: number): Observable<User[]> {
    return this.http.get<User[]>('/api/user/role/' + roleId);
  }
}
