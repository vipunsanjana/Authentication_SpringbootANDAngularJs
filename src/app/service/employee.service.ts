import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  registerEmployee(employee: any): Observable<any> {
    return this.http.post(baseUrl + '/api/v1/employee/save', employee);
  }

  loginEmployee(employee: any): Observable<any> {
    return this.http.post(baseUrl + '/api/v1/employee/login', employee);
  }
}
