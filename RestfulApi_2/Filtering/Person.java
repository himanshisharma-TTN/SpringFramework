package com.EmployeeManagment.RestfulApi_2.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"password", "phone"})
@JsonFilter("PersonFilter")
public class Person {
    String name;
    @JsonIgnore
    String password;
    String username;
    Long phone;

    public Person(String name, String password, String username, Long phone) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
