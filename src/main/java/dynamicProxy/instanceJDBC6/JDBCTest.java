package dynamicProxy.instanceJDBC6;

import com.wgc.persons.entity.Persons;
import com.wgc.persons.spring.root.SpringDAOConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class JDBCTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDAOConfig.class);
        SQLStatement bean = context.getBean(SQLStatement.class);
        Persons persons = new Persons("1", new Date(), "nan", 0, (long) 2000);
        //bean.selectAll("select * from persons");
        int add = bean.add("insert into persons(name, birthday, city, age, baborage) VALUE (?, ?, ?, ?, ?)", persons);
        if (add > 0) {
            System.out.println("成功了");
        }

    }
}
