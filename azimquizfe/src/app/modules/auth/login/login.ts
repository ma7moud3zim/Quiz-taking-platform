import { Component } from '@angular/core';
import { SharedModule } from '../../shared/shared-module';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Router } from '@angular/router';
import { Auth } from '../services/auth';
import { UserStorage } from '../services/user-storage';

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
        const user = {
          id: res.id,
          email: res.email,
          role: res.role
         };
        UserStorage.saveUser(user);
        if(UserStorage.isAdminLoggedIn()){
          this.router.navigate(['/admin/dashboard']);
        } else {
          this.router.navigate(['/user/dashboard']);
        }
        console.log(res);
      },error => {
        this.message.error(`Bad Credentials`,
          {nzDuration: 5000}
        );
        });
  }


}
