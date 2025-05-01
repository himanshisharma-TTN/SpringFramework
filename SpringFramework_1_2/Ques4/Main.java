package Ques4;

// Get a Spring Bean from application context and display its properties.

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import java.math.BigInteger;

@Configuration
@ComponentScan(basePackages = "Ques4")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Student s1 = context.getBean(Student.class);
        s1.setId(101);      s1.setName("Himanshi Sharma");      s1.setPhone(new BigInteger("9212812329"));
        System.out.println(s1.getId());
        System.out.println(s1.getName());
        System.out.println(s1.getPhone());
    }
}

@Component
class Student{
    int id;
    String name;
    BigInteger phone;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(BigInteger phone) {
        this.phone = phone;
    }

    public BigInteger getPhone() {
        return phone;
    }
}