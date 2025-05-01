package Ques3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Use @Compenent and @Autowired annotations to in Loosely Coupled code for dependency management

@Configuration
public class ExampleWithSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ExampleWithSpring.class);
        WholeClass whole = context.getBean(WholeClass.class);
        System.out.println(whole+" object is lossely coupled with "+ whole.getObj());
    }
}


@Component
class WholeClass{
    @Autowired
    DependencyClasses obj;

    WholeClass(DependencyClasses obj){
        this.obj = obj;
    }

    public DependencyClasses getObj() {
        return obj;
    }
}

@Component
interface DependencyClasses{}

@Component
@Primary
class DependencyClass1 implements DependencyClasses {
    int val=10;
}

@Component
class DependencyClass2 implements DependencyClasses {
    int val=15;
}

