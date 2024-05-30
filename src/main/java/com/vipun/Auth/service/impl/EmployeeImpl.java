package com.vipun.Auth.service.impl;

import com.vipun.Auth.dto.EmployeeDTO;
import com.vipun.Auth.dto.LoginDTO;
import com.vipun.Auth.entity.Employee;
import com.vipun.Auth.repo.EmployeeRepo;
import com.vipun.Auth.response.LoginResponse;
import com.vipun.Auth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {

        String msg = "";
        Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());
        if(employee != null){
            String password = loginDTO.getPassword();
            String encodedPassword = employee.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);

            if(isPwdRight){
                Optional<Employee> employee1 = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
                if(employee1.isPresent()){
                    return new LoginResponse("Login Successfully!",true);
                } else {
                    return new LoginResponse("Login Failed!",false);
                }
            }else{
                return new LoginResponse("Password not match!",false);
            }
        }else {
            return new LoginResponse("Email not exits!",false);
        }
    }
}
