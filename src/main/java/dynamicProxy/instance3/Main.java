package dynamicProxy.instance3;

import net.sf.cglib.proxy.Enhancer;

public class Main {

    public static void main(String[] args) {
        /**/
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Thread.currentThread().getContextClassLoader());
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new CGLibProxy());

        Dog o = (Dog) enhancer.create();
        o.to();

        /*链式操作*/
        Dog dog = (Dog) Enhancer.create(Dog.class, null, new CGLibProxy());
        dog.buy(333);

    }
}
