import { ChangeDetectorRef, Component, ElementRef } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { Test } from '../../services/test';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';

@Component({
  selector: 'app-take-test',
  imports: [SharedModule],
  templateUrl: './take-test.html',
  styleUrl: './take-test.scss',
})
export class TakeTest {
  questions: any[] = [];
  testId: any;
  constructor(
    private testService: Test,
    private activatedRoute: ActivatedRoute,
    private message: NzMessageService,
    private router: Router,
    private cdr: ChangeDetectorRef,
    private el: ElementRef,
  ) {}

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((params) => {
      this.testId = +params.get('id');
      this.testService.getTestQuestions(this.testId).subscribe((res) => {
        this.questions = res.questions;
        this.refresh();
      });
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
