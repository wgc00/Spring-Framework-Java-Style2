package dynamicProxy.instance4;

import com.wgc.persons.spring.root.SpringDAOConfig;
import dynamicProxy.instance4.animal.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDAOConfig.class);
        Dog bean = context.getBean(Dog.class);
        bean.introduced();
    }
}
