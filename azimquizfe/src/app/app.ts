import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLinkActive, Router } from '@angular/router';
import { SharedModule } from './modules/shared/shared-module';
import { UserStorage } from './modules/auth/services/user-storage';

@Component({
  selector: 'app-root',
  imports: [SharedModule, RouterLinkActive],
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App {
  protected readonly title = signal('azimquizfe');
  isUserLoggedIn: boolean = UserStorage.isUserLoggedIn();
  isAdminLoggedIn: boolean = UserStorage.isAdminLoggedIn();

  constructor(private router: Router) {}

  ngOnInit() {
    this.router.events.subscribe(() => {
      this.isUserLoggedIn = UserStorage.isUserLoggedIn();
      this.isAdminLoggedIn = UserStorage.isAdminLoggedIn();
    });
  }

  logout(): void {
    UserStorage.signOut();
    this.router.navigate(['/login']);
  }
  forceReflow() {
    void document.body.offsetHeight;
  }
}
