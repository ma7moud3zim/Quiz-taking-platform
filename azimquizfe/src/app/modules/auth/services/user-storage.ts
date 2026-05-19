import { Injectable } from '@angular/core';

const USER = 'q-user';

@Injectable({
  providedIn: 'root',
})
export class UserStorage {
  constructor() {}

  static saveUser(user: any): void {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }

  static getUser(): any {
    const user = localStorage.getItem(USER);
    return user ? JSON.parse(user) : null;
  }


  static getUserId(): string {
    const user = this.getUser();
    return user ? user.id : '';
  }

  static getUserRole(): string {
    const user = this.getUser();
    return user ? user.role : '';
  }

  static isAdminLoggedIn(): boolean {
    const user = this.getUser();
    return user ? user.role === 'ADMIN' : false;
  }

  static isUserLoggedIn(): boolean {
    const user = this.getUser();
    return user ? user.role === 'USER' : false;
  }

  static signOut(): void {
    window.localStorage.removeItem(USER);
  }


}
