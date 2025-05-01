package com.EmployeeManagment.RestfulApi_2.Versoning_Hateos_Internationalization;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/emp1")
public class EmployeeVersion1Controller_Hateos {
    EmployeeService employeeService;
    private final MessageSource messageSource;

    @Autowired
    EmployeeVersion1Controller_Hateos(EmployeeService employeeService, MessageSource messageSource){
        this.employeeService=employeeService;
        this.messageSource=messageSource;
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EntityModel<Employee> getEmployee(@PathVariable Long id){
        Employee employee = employeeService.getEmployee(id);
        if (employee==null) throw new EmployeeNotFoundException();
        EntityModel<Employee> entityModel = EntityModel.of(employee);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEmployee());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }

    @GetMapping("/greeting")
    public String getInternationalizedHello(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }

    @PostMapping("/v1/addemp")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping(name = "/updateemp", params = "version=1")
    public Employee updateEmployee(@Valid @RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping(value = "/deleteemp", headers = "X-API-VERSION=1")
    public String deleteEmployee(@RequestBody Long id){
        employeeService.deleteEmployee(id);
        return "Employee Deleted";
    }

}
