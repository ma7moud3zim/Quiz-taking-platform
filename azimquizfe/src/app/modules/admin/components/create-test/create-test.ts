import { registerLocaleData } from '@angular/common';
import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-test',
  imports: [SharedModule],
  templateUrl: './create-test.html',
  styleUrl: './create-test.scss',
})


export class CreateTest {

  constructor(private fb: FormBuilder) {}

  testForm!: FormGroup;

  ngOnInit(){
    this.testForm = this.fb.group({
      title: [null, Validators.required],
      description: [null, Validators.required],
      time: [null, Validators.required],
    })
  }

}
