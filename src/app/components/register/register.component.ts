import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmployeeService } from '../../service/employee.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'] // Corrected property name
})
export class RegisterComponent implements OnInit {

  registerEmployeeForm!: FormGroup;


  constructor(
   
    private employeeService: EmployeeService,
    private fb: FormBuilder,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.registerEmployeeForm = this.fb.group({
      name: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      password: [null, [Validators.required]],
    });
  }

  registerEmployee(): void {
    if (this.registerEmployeeForm.valid) {
      this.employeeService.registerEmployee(this.registerEmployeeForm.value).subscribe(
        (res) => {
          console.log(res);
          this.toastr.success('Registered successfully!');
          this.router.navigateByUrl("/");
        },
        (err) => {
          console.error(err);
          this.toastr.error('Registration failed.');
        }
      );
    } else {
      this.toastr.warning('Please fill out the form correctly.');
    }
  }

  getLogin(): void {
    this.router.navigateByUrl("/");
  }
}
