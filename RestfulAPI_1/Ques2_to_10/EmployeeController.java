package com.EmployeeManagment.RestfulAPI_1.Ques2_to_10;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Employee getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null) throw new EmployeeNotFoundException();
        return employeeService.getEmployee(id);
    }

    @PostMapping("/addemp")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/updateemp")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteemp")
    public String deleteEmployee(@RequestBody Long id){
        employeeService.deleteEmployee(id);
        return "Employee Deleted";
    }

}
