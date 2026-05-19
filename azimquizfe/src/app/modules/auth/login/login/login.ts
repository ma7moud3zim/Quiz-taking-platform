import { Component } from '@angular/core';
import { SharedModule } from '../../../shared/shared-module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
import { Auth } from '../../services/auth';

@Component({
  selector: 'app-login',
  imports: [SharedModule],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
  constructor(private fb:FormBuilder,
    private authService:Auth,
    private message:NzMessageService,
    private router:Router,) {}
    validateForm!: FormGroup;

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
    });
  }

  submitForm(): void {
    this.authService.login(this.validateForm.value).subscribe(res=>{
      this.message.
      success('Login successful', {
        nzDuration: 5000});
        console.log(res);
      },error => {
        this.message.error(`Bad Credentials`,
          {nzDuration: 5000}
        );
        });
  }


}
