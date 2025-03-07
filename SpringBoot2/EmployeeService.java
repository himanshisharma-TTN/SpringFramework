package com.EmployeeManagment.SpringBoot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Map<String,?> getEmployee(Long id){
        Employee employee = employeeRepository.getReferenceById(id);
        String message = "Employee Found";
        if(employee==null) message="Employee Not Found";
        return Map.of("message","Employee Not Found","Employee",employee);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
