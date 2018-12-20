package transaction.instance1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;

public class TransactionTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transaction/spring-transaction.xml");
        DataSources bean = context.getBean(DataSources.class);
        TransactionDefinition definition = new DefaultTransactionDefinition();
        PlatformTransactionManager transactionManager = (PlatformTransactionManager) context.getBean("dataSourceTransactionManager");
        TransactionStatus transaction = transactionManager.getTransaction(definition);
        try {
            bean.add("张三");
        } catch (SQLException e) {
            System.out.println("提交");
            transactionManager.commit(transaction);
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("回滚");
            transactionManager.rollback(transaction);
          //  e.printStackTrace();
        }
    }
}
