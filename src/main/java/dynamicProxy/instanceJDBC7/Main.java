package dynamicProxy.instanceJDBC7;

import com.wgc.persons.spring.root.SpringDAOConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDAOConfig.class);
        SQLStatement bean = context.getBean(SQLStatement.class);
        try {
            bean.add("dd");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("报错");
        }
    }
}
