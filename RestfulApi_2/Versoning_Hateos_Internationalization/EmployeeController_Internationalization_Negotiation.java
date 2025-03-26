package com.EmployeeManagment.RestfulApi_2.Versoning_Hateos_Internationalization;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/emp")
public class EmployeeController_Internationalization_Negotiation {

    EmployeeService employeeService;
    private final MessageSource messageSource;

    @Autowired
    EmployeeController_Internationalization_Negotiation(EmployeeService employeeService, MessageSource messageSource){
        this.employeeService=employeeService;
        this.messageSource=messageSource;
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

    @GetMapping("/greeting")
    public String getInternationalizedHello(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

    @PostMapping("/addemp")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/updateemp")
    public Employee updateEmployee(@Valid @RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteemp")
    public String deleteEmployee(@RequestBody Long id){
        employeeService.deleteEmployee(id);
        return "Employee Deleted";
    }

}
