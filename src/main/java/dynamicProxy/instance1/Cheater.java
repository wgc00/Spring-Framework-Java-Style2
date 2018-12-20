package dynamicProxy.instance1;

public class Cheater implements Examable {

    private Examable student;

    public Cheater(Examable student) {
        this.student = student;
    }
    @Override
    public void exam() {
        student.exam();
        System.out.println("考完试回家！");
    }
}
