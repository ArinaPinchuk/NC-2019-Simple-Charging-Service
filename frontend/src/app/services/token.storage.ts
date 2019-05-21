import {Injectable} from '@angular/core';

const TOKEN_KEY = 'AuthToken';
const LOGIN: string = 'Login';

@Injectable()
export class TokenStorage {

  constructor() {
  }

  signOut() {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.removeItem(LOGIN);
    window.sessionStorage.clear();
  }

  public saveToken(token: string, username: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.removeItem(LOGIN);
    window.sessionStorage.setItem(TOKEN_KEY, token);
    window.sessionStorage.setItem(LOGIN, username);
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public getLogin(): string {
    return sessionStorage.getItem(LOGIN);
  }
}
