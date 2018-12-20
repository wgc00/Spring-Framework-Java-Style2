package dynamicProxy.instance1;

public class Student implements Examable {
    @Override
    public void exam() {
        System.out.println("完成考试");
    }
}
