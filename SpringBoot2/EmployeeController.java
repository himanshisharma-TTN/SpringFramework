package com.EmployeeManagment.SpringBoot2;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping
    public String test(){
        return "Working";
    }

    @GetMapping("/{id}")
    public Map<String,?> getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("/addemp")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }
}
