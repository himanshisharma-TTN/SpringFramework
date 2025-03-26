package com.EmployeeManagment.RestfulAPI_1.Ques2_to_10;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handlerForEmployeeNotFoundException(Exception e, WebRequest request) throws Exception{
        ErrorDetails errorDetails = new ErrorDetails(e.getClass().getName(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handlerForAllExceptions(Exception e, WebRequest request) throws Exception{
        ErrorDetails errorDetails = new ErrorDetails(e.getClass().getName(),e.getMessage(),request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}

class ErrorDetails{
    String name;
    String message;
    String description;

    public ErrorDetails(String name, String message, String description) {
        this.name = name;
        this.message = message;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


