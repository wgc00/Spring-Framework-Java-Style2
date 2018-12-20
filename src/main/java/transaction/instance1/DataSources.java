package transaction.instance1;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DataSources {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3308/demo");
        return connection;
    }

    public void add(String name) throws SQLException, ClassNotFoundException {
        getConnection().setAutoCommit(false);
        PreparedStatement statement = getConnection().prepareStatement("insert into demo.p_user(name) values (?)");
        statement.setString(1, name);
        statement.executeUpdate();
        getConnection().commit();

        /*关闭资源*/
        statement.close();
        getConnection().close();
    }
}
