import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Role} from "../models/role";

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) {
  }
  attemptAuth(ussername: string, password: string): Observable<any> {
    const credentials = {username: ussername, password: password};
    return this.http.post('/api/token', credentials);
  }
}
