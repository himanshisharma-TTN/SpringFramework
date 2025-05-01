package com.EmployeeManagment.SpringBoot2;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping
    public List<Employee> test(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/addemp")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }
}
