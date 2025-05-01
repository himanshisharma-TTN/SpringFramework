package com.EmployeeManagment.RestfulAPI_1.Ques1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MainContext {
    public static void main(String[] args) {
        SpringApplication.run(MainContext.class);
    }
}


@RestController
class SpringBootController{
    @GetMapping("/welcome")
    public String printWelcomeToSpringBoot(){
        return "Welcome to spring boot Everyone";
    }
}