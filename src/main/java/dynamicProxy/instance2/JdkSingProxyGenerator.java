package dynamicProxy.instance2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*实现一个InvocationHandler就能使用jdk代理*/
public class JdkSingProxyGenerator implements InvocationHandler {

    private Object object;

    public JdkSingProxyGenerator(Object obj) {
        this.object = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        //前置通知（advice） 这里是额外的功能，放在前面的功能
        System.out.println("被调用方法的名字：" + method.getName());
        try {
            // 1
            long beingTime = System.currentTimeMillis();

            System.out.println("每个人都要唱一首歌");

            Object result = method.invoke(object, args);
            // 2 环绕通知 (Around Advice)
            System.out.println("进入这个方法的时间：" + (System.currentTimeMillis() - beingTime) + "毫秒");

            //返回前的通知 (Before Returning Advice), 能使用到 result 的参数
            System.out.println("运行的函数结果：" + result);
            return result;
        } catch (Exception e) {
            //异常通知 (After Throwing)
            System.out.println("你的类没有基于接口，请修改一下");
            return null;
        } finally {
            //最终通知 (After Advice)
            //比如：数据库连接的清理
        }

    }
}
