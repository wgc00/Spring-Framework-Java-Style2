package dynamicProxy.instanceJDBC7;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class SQLStatement {
    public void add(String name) throws SQLException {
        Connections.conn().createStatement().execute("insert into demo.p_user(name) value ('" + name + "')");
    }
}
