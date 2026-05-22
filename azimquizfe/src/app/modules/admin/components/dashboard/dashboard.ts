import { ChangeDetectorRef, Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { Admin } from '../../services/admin';

@Component({
  selector: 'app-dashboard',
  imports: [SharedModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.scss',
})
export class Dashboard {
  tests = [];

  constructor(private notification: NzNotificationService, private testService: Admin,  private cdr: ChangeDetectorRef) {
  }

  ngOnInit() {
    this.getAllTests();
    this.cdr.detectChanges();
  }

  getAllTests() {
    this.testService.getAllTest().subscribe(res=>{
        this.tests = res;
      },error=>{
        this.notification
       .error('Error', `Failed to fetch tests`, {nzDuration: 5000})
      })
    }

    getFormatedTime(time):string{
      const minutes = Math.floor(time / 60);
      const seconds = time % 60;
      return `${minutes}m ${seconds}s`;
    }

}
