package com.vipun.Auth.controller;

import com.vipun.Auth.dto.EmployeeDTO;
import com.vipun.Auth.dto.LoginDTO;
import com.vipun.Auth.response.LoginResponse;
import com.vipun.Auth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/register")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){

        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){

        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
