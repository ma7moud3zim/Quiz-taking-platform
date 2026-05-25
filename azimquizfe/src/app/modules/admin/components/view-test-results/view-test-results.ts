import { ChangeDetectorRef, Component, ElementRef } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { Admin } from '../../services/admin';

@Component({
  selector: 'app-view-test-results',
  imports: [SharedModule],
  templateUrl: './view-test-results.html',
  styleUrl: './view-test-results.scss',
})
export class ViewTestResults {
  resultsData: any;

  constructor(
    private testServices: Admin,
    private cdr: ChangeDetectorRef,
    private el: ElementRef,
  ) {}

  ngOnInit() {
    this.getTestResults();
  }
  getTestResults() {
    this.testServices.getTestResults().subscribe((res) => {
      this.resultsData = res;
      console.log(this.resultsData);
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
