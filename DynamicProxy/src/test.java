import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args)
    {
        //    我们要代理的真实对象
        Subject realSubject = new RealSubject();
        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        //MyProxy是一个可复用的类,位于动态代理类和原始类之间.动态代理类会调用它的方法
        InvocationHandler handler = new LoggerHandler(realSubject);
        /*
         * 通过Proxy类的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，
         * 表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        //newProxyInstance()作用得到一个动态代理对象.
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);
        //System.out.println(subject.getClass().getName());
        subject.rent();
        System.out.println("***********");
        subject.hello("world");
    }
}
