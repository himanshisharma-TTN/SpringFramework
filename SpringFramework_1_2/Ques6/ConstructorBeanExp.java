package Ques6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Perform Constructor Injection in a Spring Bean

@Configuration
@ComponentScan(basePackages = "Ques6")
public class ConstructorBeanExp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConstructorBeanExp.class);
        NewClass newClass = context.getBean(NewClass.class);
        System.out.println(newClass.getFIELD().val);
    }
}

@Component
class NewClass{
    private final DependencyCLass FIELD ;

    @Autowired
    NewClass(DependencyCLass field){
        this.FIELD = field;
    }

    public DependencyCLass getFIELD() {
        return FIELD;
    }
}

@Component
class DependencyCLass{
    int val=20;
}