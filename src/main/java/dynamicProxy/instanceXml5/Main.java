package dynamicProxy.instanceXml5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-aop/spring-aop.xml");
        Cat bean = context.getBean(Cat.class);
        bean.to();

    }
}
