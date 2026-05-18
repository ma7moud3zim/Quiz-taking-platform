import { Component, signal } from '@angular/core';
import { RouterOutlet, RouterLinkActive } from '@angular/router';
import { SharedModule } from './modules/shared/shared-module';

@Component({
  selector: 'app-root',
  imports: [SharedModule, RouterLinkActive],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  protected readonly title = signal('azimquizfe');
}
