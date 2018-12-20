package dynamicProxy.instanceJDBC7;

import java.sql.Connection;

public class Connections {

    public  static ThreadLocal<Connection> threadLocal = null;

    public static Connection conn() {
        return threadLocal.get();
    }
}
