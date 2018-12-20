package dynamicProxy.instanceJDBC6;


import com.wgc.persons.entity.Persons;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Aspect
//@Component
public class ConnectionAdvice {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    @Pointcut(value = "execution(* dynamicProxy.instanceJDBC6.SQLStatement.selectAll(..))")
    public void select(){}
    /**/
   /* @Around("select()")
    public List<Persons> getQueryAll(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("进入了Around");
        getConnection().setAutoCommit(false);
        statement =  getConnection().prepareStatement(joinPoint.getArgs()[0].toString());
        resultSet = statement.executeQuery();
        List<Persons> result = result(resultSet);
        return result;

    }*/
    @After(value = "execution(* dynamicProxy.instanceJDBC6.SQLStatement.add(..))")
    public int getAdd(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("进入了getAdd");
        getConnection().setAutoCommit(false);
        /*Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            return 0;
        }
        statement = getConnection().prepareStatement("insert into persons(name, birthday, city, age, baborage) VALUE (?, ?, ?, ?, ?)");
       // BigDecimal decimal = new BigDecimal();
        for (int i = 1; i < args.length; i++) {
            statement.setObject(i, args[i]);
        }
        int i = statement.executeUpdate();
        return i;*/
        Object proceed = joinPoint.proceed();
        return 0;
    }

    @After(value = "execution(* dynamicProxy.instanceJDBC6.SQLStatement.*(..))")
    public void clones() {
        System.out.println("进入了clone");
        cloneConnection();
    }


    @AfterThrowing(value = "execution(* dynamicProxy.instanceJDBC6.SQLStatement.*(..))")
    public void connectionCloneError() {
        System.out.println("进入了connectionError");
        cloneConnection();
    }

    private void cloneConnection() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("关闭连接");
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            try {
                getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Persons> result(ResultSet resultSet) throws SQLException {
        List<Persons> list = new ArrayList<>();
        while (resultSet.next()) {
            Persons persons = new Persons();
            persons.setId(resultSet.getInt(1));
            persons.setName(resultSet.getString(2));
            persons.setBirthday(resultSet.getDate(3));
            persons.setCity(resultSet.getString(4));
            persons.setAge(resultSet.getInt(5));
            persons.setBaborage(resultSet.getLong(6));
           // System.out.println(resultSet.getString(2));
            list.add(persons);
        }
        return list;
    }
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/demo", "root", "123456");
        return connection;
    }
}
