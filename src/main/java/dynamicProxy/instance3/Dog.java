package dynamicProxy.instance3;

public class Dog {

    public void to() {
        System.out.println("汪汪汪汪汪汪");
    }

    public void buy(int price) {
        int primePrice = 1000;
        System.out.println("这条狗的价格为：" + (primePrice - price));
    }
}
