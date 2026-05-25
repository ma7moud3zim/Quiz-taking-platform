import { ChangeDetectorRef, Component, ElementRef } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { Test } from '../../services/test';

@Component({
  selector: 'app-view-my-test-results',
  imports: [SharedModule],
  templateUrl: './view-my-test-results.html',
  styleUrl: './view-my-test-results.scss',
})
export class ViewMyTestResults {
  dataSet: any;

  constructor(
    private testService: Test,
    private cdr: ChangeDetectorRef,
    private el: ElementRef,
  ) {}

  ngOnInit() {
    this.getTestResults();
    this.refresh();
  }

  getTestResults() {
    this.testService.getMyTestResults().subscribe((res) => {
      this.dataSet = res;
      console.log(this.dataSet);
      this.refresh();
    });
  }

  ngAfterViewInit() {
    this.refresh();
  }

  private refresh() {
    this.cdr.detectChanges();
    void this.el.nativeElement.offsetHeight;
  }
}
