package dynamicProxy.instanceJDBC6;

import com.wgc.persons.entity.Persons;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SQLStatement {

    public List<Persons> selectAll(String sql)  {
       return null;
    }

    public int add(String sql, Object... objects) {
        return 0;
    }
}
