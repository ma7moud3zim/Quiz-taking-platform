import { ChangeDetectorRef, Component, ElementRef } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { ActivatedRoute } from '@angular/router';
import { Admin } from '../../services/admin';

@Component({
  selector: 'app-view-test',
  imports: [SharedModule],
  templateUrl: './view-test.html',
  styleUrl: './view-test.scss',
})
export class ViewTest {

  questions: any[] = [];
  testId: any;

  constructor(
    private adminService: Admin,
    private activatedRoute: ActivatedRoute,
    private cdr: ChangeDetectorRef,
    private el: ElementRef
  ) {}

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      this.testId = +params.get('id');
      this.adminService.getTestQuestions(this.testId).subscribe(res => {
        this.questions = res.questions;
        console.log(this.questions);
        this.cdr.detectChanges();
        this.forceReflow();
      });
    });
  }

  ngAfterViewInit() {
    this.cdr.detectChanges();
    this.forceReflow();
  }

  private forceReflow() {
    void this.el.nativeElement.offsetHeight;
  }
}
