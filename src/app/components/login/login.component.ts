import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from '../../service/employee.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] 
})
export class LoginComponent implements OnInit {

  loginEmployeeForm!: FormGroup;

  constructor(
    private employeeService: EmployeeService,
    private fb: FormBuilder,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.loginEmployeeForm = this.fb.group({
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
    });
  }

  loginEmployee(): void {
    if (this.loginEmployeeForm.valid) {
      console.log(this.loginEmployeeForm.value);
      this.employeeService.loginEmployee(this.loginEmployeeForm.value).subscribe(
        (res) => {
          console.log(res);
          this.toastr.success('Login successfully!');
          this.router.navigateByUrl("/home");
        },
        (err) => {
          console.error(err);
          this.toastr.error('Failed to log in.');
        }
      );
    } else {
      this.toastr.warning('Please fill out the form correctly.');
    }
  }

  getRegister(): void {
    this.router.navigateByUrl("/save");
  }
}
