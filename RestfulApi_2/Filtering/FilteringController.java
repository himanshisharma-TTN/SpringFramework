package com.EmployeeManagment.RestfulApi_2.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filtering")
public class FilteringController {

    @GetMapping
    public Person getStaticFilteredData(){
        return new Person("Himanshi","password","himanshi@123",12345L);
    }

    @GetMapping("/list")
    public List<Person> getListOfPersons(){
        List<Person> list = List.of(new Person("Himanshi","password","himanshi@123",12345L),
                new Person("Karan","password","Karan@123",12345L),
                new Person("Priyanka","password","priyanka@123",12345L));
        return list;
    }

    @GetMapping("custom-filtered-list")
    public MappingJacksonValue getListOfPersonsCustom(){
        List<Person> person = List.of(new Person("Himanshi","password","himanshi@123",12345L),
                new Person("Karan","password","karan@123",12345L));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(person);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
        FilterProvider filters = new SimpleFilterProvider().addFilter("PersonFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}
