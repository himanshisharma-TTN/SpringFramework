package com.EmployeeManagment.RestfulAPI_1.Ques2_to_10;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(){
        super("Employee Not Found");
    }
}
