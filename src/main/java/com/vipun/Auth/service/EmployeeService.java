package com.vipun.Auth.service;

import com.vipun.Auth.dto.EmployeeDTO;
import com.vipun.Auth.dto.LoginDTO;
import com.vipun.Auth.response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
