package com.vipun.Auth.service.impl;

import com.vipun.Auth.dto.EmployeeDTO;
import com.vipun.Auth.entity.Employee;
import com.vipun.Auth.repo.EmployeeRepo;
import com.vipun.Auth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(

                employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())

        );
employeeRepo.save(employee);
        System.out.println(employee);

        return employee.getName();
    }
}
