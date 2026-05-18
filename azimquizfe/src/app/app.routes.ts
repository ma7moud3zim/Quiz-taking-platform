import { Signup } from './modules/auth/signup/signup';
import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'register',
    component: Signup
  }
];
