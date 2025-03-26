package com.EmployeeManagment.RestfulAPI_1.Ques2_to_10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    public Employee getEmployee(Long id){
        Employee employee = employeeRepository.getReferenceById(id);
        System.out.println(employee);
        return employee;
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        Employee employee1 = employeeRepository.getReferenceById(employee.getId());
        employee1.setName(employee.getName());
        employee1.setDepartment(employee.getDepartment());
        employee1.setEmail(employee.getEmail());
        employee1.setDesignation(employee.getDesignation());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        Optional<Employee> employee1 = employeeRepository.findById(id);
        if (employee1.isEmpty()) throw new EmployeeNotFoundException();
        employeeRepository.deleteById(id);
    }
}
