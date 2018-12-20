package dynamicProxy.instance4;

//@Aspect
//@Component
public class TypeMethod {


    //@After("execution(void dynamicProxy.instance4.*.*.*(..))")
    public void to() {
        System.out.println("结束做什么事情");
    }

   // @Before("execution(void dynamicProxy.instance4.animal.Dog.*(..))")
    public void before() {
        System.out.println("开始做什么事情");
    }

   // @AfterReturning("execution(public * *.*(..))")
    public void AfterReturning() {
        System.out.println("method AfterReturning");
    }
}
