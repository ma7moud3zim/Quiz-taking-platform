import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../../services/admin';

@Component({
  selector: 'app-add-question-in-test',
  imports: [SharedModule],
  templateUrl: './add-question-in-test.html',
  styleUrl: './add-question-in-test.scss',
})
export class AddQuestionInTest {
  constructor(private fb: FormBuilder,
    private adminService: Admin,
    private notification: NzNotificationService,
    private router: Router,
    private avtivatedRoute: ActivatedRoute
  ) { }

  id: number | null;
  questionForm!: FormGroup;


  ngOnInit() {
    this.questionForm = this.fb.group({
      questionText: [null , [Validators.required]],
      OptionA: [null , [Validators.required]],
      OptionB: [null , [Validators.required]],
      OptionC: [null , [Validators.required]],
      OptionD: [null , [Validators.required]],
      correctAnswer: [null , [Validators.required]],
    });

    this.id = this.avtivatedRoute.snapshot.paramMap['id'];

  }

}
