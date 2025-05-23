package com.EmployeeManagment.RestfulApi_2.Versoning_Hateos_Internationalization;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(){
        super("Employee Not Found");
    }
}
