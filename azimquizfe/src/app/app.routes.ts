import { Login } from './modules/auth/login/login/login';
import { Signup } from './modules/auth/signup/signup';
import { Routes } from '@angular/router';

export const routes: Routes = [
  {path: 'register',component: Signup},
  {path: 'login',component: Login},
];
