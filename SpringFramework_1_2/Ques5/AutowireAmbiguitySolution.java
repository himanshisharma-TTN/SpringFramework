package Ques5;

//Demonstrate how you will resolve ambiguity while autowiring bean

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "Ques5")
public class AutowireAmbiguitySolution {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutowireAmbiguitySolution.class);

        Cake chocolate = context.getBean(Cake.class);
        chocolate.getCake().getReadyCake();

        Cake butterscotch = context.getBean(Cake.class);
        butterscotch.setCake(context.getBean(ButterscotchCake.class));
        butterscotch.getCake().getReadyCake();

    }
}

@Component
class Cake{
    private TypeCake cake;

    @Autowired
    void setCake(@Qualifier("Chocolate") TypeCake cake){
        this.cake=cake;
    }

    public TypeCake getCake() {
        return cake;
    }
}

@Component
interface TypeCake{
    void getReadyCake();
}

@Component("Chocolate")
class ChocolateCkae implements TypeCake{
    @Override
    public void getReadyCake() {
        System.out.println("Chocolate Ckae is Ready Now ...... ");
    }
}

@Component("Butterscotch")
@Primary
class ButterscotchCake implements TypeCake{
    @Override
    public void getReadyCake() {
        System.out.println("Butterscotch Ckae is Ready Now ...... ");
    }
}
