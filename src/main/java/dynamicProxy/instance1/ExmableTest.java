package dynamicProxy.instance1;

public class ExmableTest {

    public static void main(String[] args) {

        Examable s = new Student();
        Examable t = new Cheater(s);
        t.exam();
    }
}
