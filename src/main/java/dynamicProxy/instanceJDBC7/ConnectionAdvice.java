package dynamicProxy.instanceJDBC7;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Aspect
@Component
public class ConnectionAdvice {

    @Around(value = "execution(* dynamicProxy.instanceJDBC7.SQLStatement.add(..))")
    public Object wrapDAO(ProceedingJoinPoint jp) {
        Connection connection = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/demo", "root", "123456");
            connection.setAutoCommit(false);
            Connections.threadLocal = new ThreadLocal<>();
            Connections.threadLocal.set(connection);
            Object proceed = jp.proceed();
            connection.commit();
            return proceed;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @After(value = "execution(* dynamicProxy.instanceJDBC7.SQLStatement.add(..))")
    public void clones() throws SQLException {
        Connections.conn().close();
        System.out.println("关闭了");
    }
}
